package com.paw.servertrello.services;

import java.util.ArrayList;

import com.paw.servertrello.models.Credentials;
import com.paw.servertrello.models.UserModel;

public class LoginService 
{
    public static UserModel login(Credentials credentials)
    {
    	try
    	{
    		ArrayList<UserModel> usersList = UserService.selectAllUsers();
    		UserModel user = usersList.stream().filter(w->w.getName().equals(credentials.getLogin())).findAny().get();    		
			if(user.getPass().equals(credentials.getPassword()))
			{
				user.setBoardsList(BoardService.selectBoardsByUserId(user.getUserId()));
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
