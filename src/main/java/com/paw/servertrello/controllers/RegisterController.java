package com.paw.servertrello.controllers;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.UserModel;
import com.paw.servertrello.services.RegisterService;

@InterceptorRef("myStack")
public class RegisterController implements ModelDriven<Object>
{
	private boolean isUserRegistered;
    private String msg = "";
    private Collection<Boolean> list;
    
    public HttpHeaders show() 
    {
    	try
    	{
			String fullname = ServletActionContext.getRequest().getParameter("fullname").toString();	
			String email = ServletActionContext.getRequest().getParameter("email").toString();
			String name = ServletActionContext.getRequest().getParameter("name").toString();
			String pass = ServletActionContext.getRequest().getParameter("pass").toString();
			UserModel user = new UserModel(fullname, email, name, pass);
    		isUserRegistered = RegisterService.register(user);
    		msg = "{msg: "+isUserRegistered+"}";
	        return new DefaultHttpHeaders("show").disableCaching();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return new DefaultHttpHeaders("show").withStatus(403);
    	}
    }
    
    
	@Override
	public Object getModel() {
		 return (list != null ? list : msg);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Collection<Boolean> getList() {
		return list;
	}

	public void setList(Collection<Boolean> list) {
		this.list = list;
	}
    
}
