package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.UserModel;
import com.paw.servertrello.services.BoardService;
import com.paw.servertrello.services.UserService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;


@InterceptorRef("myStack")
public class UserController implements ModelDriven<Object>
{
    private UserModel user = new UserModel();
    private long id;
    private Collection<UserModel> list;
    
    public HttpHeaders execute() 
    {
    	try
    	{
			String fullname = ServletActionContext.getRequest().getHeader("fullname").toString();	
			String email = ServletActionContext.getRequest().getHeader("email").toString();
			String name = ServletActionContext.getRequest().getHeader("name").toString();
			String pass = ServletActionContext.getRequest().getHeader("pass").toString();
			user = new UserModel(fullname, email, name, pass);
			
			System.out.println(fullname+" "+email+" "+name+" "+pass);
		
	        return new DefaultHttpHeaders("execute").disableCaching();
			
    	}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
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
