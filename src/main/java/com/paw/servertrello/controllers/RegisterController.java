package com.paw.servertrello.controllers;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.Credentials;
import com.paw.servertrello.models.UserModel;
import com.paw.servertrello.services.LoginService;
import com.paw.servertrello.services.RegisterService;


@InterceptorRef("myStack")
public class RegisterController implements ModelDriven<Object>
{
    private UserModel user = new UserModel();
    private Credentials credentials = new Credentials();
    
  
    
    public void create()
    {
    	try
    	{
			user = new UserModel(credentials.getFullname(), credentials.getEmail(), credentials.getLogin(), credentials.getPassword());
	        if(user== null) throw new Exception();
	        boolean isUserRegistered = RegisterService.register(user);
	        if(isUserRegistered == false) throw new Exception();
	        user = LoginService.login(credentials);
	        credentials = null;
	        String pathRaw= ServletActionContext.getRequest().getRequestURL().toString();
	        String path = pathRaw.replace("register", "user");
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
