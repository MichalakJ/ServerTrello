package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.actions.UserService;
import com.paw.servertrello.lib.UserModel;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

@InterceptorRef("myStack")
public class UserController implements ModelDriven<Object>
{
    private UserModel user = new UserModel();
    private long id;
    private Collection<UserModel> list;

    public HttpHeaders show() 
    {
		try
		{
			String name = ServletActionContext.getRequest().getHeader("name").toString();
			String pass = ServletActionContext.getRequest().getHeader("pass").toString();
			user = UserService.selectUserByName(name);			  
			if(user.getPass().equals(pass)) 
			{
				user.setBoardsList(BoardService.selectBoardsByUserId(user.getUserId()));
				return new DefaultHttpHeaders("index").disableCaching();
			}
			else 
			{
				user = null;
				return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			user = null;
			return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
		}
    }	


    @Override
    public Object getModel() {
        return (list != null ? list : user);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<UserModel> getList() {
        return list;
    }

    public void setList(Collection<UserModel> list) {
        this.list = list;
    }
}
