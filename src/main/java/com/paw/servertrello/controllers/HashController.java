package com.paw.servertrello.controllers;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.BoardModel;
import com.paw.servertrello.services.BoardService;
import com.paw.servertrello.services.UserService;

@InterceptorRef("myStack")
public class HashController implements ModelDriven<Object>
{
	String hash= "jnkjj";
    private Collection<String> list;
	
    
    public HttpHeaders show() 
    {
    	String name= ServletActionContext.getRequest().getParameter("login");
    	hash = "{\"hash\": \""+UserService.selectUserByName(name).getHash()+"\"}";
        if(hash == null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        return new DefaultHttpHeaders("show").disableCaching();
    }
    

    @Override
    public Object getModel() {
        return (list != null ? list : hash);
    }


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
