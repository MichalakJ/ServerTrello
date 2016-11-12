package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.LoginService;
import com.paw.servertrello.lib.Credentials;
import com.paw.servertrello.lib.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

/**
 * Created by Jakub on 2016-10-24.
 */
@InterceptorRef("myStack")
public class LoginController implements ModelDriven<Object>{

    private User user = new User();
    private Credentials credentials = new Credentials();
    public HttpHeaders create() {
        user = LoginService.login(credentials);
        credentials = null;
        if(user==null){
            return new DefaultHttpHeaders("create").withStatus(403);
        }
        String path= ServletActionContext.getRequest().getRequestURL().toString().replace("login", "users");
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(user.getId()));
    }
    @Override
    public Object getModel() {
        return (credentials != null ? credentials : user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
