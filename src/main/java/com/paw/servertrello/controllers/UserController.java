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
    
    public HttpHeaders show()
    {
    	user = UserService.find(id);
        if(user==null){
            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("show").disableCaching();
    }
    
    public HttpHeaders index()
    {
    	 user = UserService.find(id);
    	 return new DefaultHttpHeaders("index").disableCaching();
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
