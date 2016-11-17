package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.Credentials;
import com.paw.servertrello.models.UserModel;
import com.paw.servertrello.services.LoginService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;

@InterceptorRef("myStack")
public class LoginController implements ModelDriven<Object>{

    private UserModel user = new UserModel();
    private Credentials credentials = new Credentials();
    
    public void create()
    {
    	try
    	{
    		UserModel user = new UserModel();
	        user = LoginService.login(credentials);
	        if(user== null) throw new Exception();
	        credentials = null;
	        String pathRaw= ServletActionContext.getRequest().getRequestURL().toString();
	        String path = pathRaw.replace("login", "user");
	        ServletActionContext.getResponse().sendRedirect(path + Long.toString(user.getUserId())+".json");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    @Override
    public Object getModel() {
        return (credentials != null ? credentials : user);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
