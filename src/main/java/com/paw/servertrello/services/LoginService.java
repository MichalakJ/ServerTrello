package com.paw.servertrello.services;

import com.paw.servertrello.models.Credentials;
import com.paw.servertrello.models.UserModel;

public class LoginService 
{
    public static UserModel login(Credentials credentials)
    {
    	try
    	{
    		UserModel user = UserService.selectUserByName(credentials.getLogin());
			if(user.getPass().equals(credentials.getPassword()))
			{
				
				return user;
			}
			else throw new Exception();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return null;
    	}
    }
}
