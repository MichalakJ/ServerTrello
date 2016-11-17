package com.paw.servertrello.services;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.UserModel;

public class RegisterService 
{
    public static boolean register(UserModel user)
    {
    	try
    	{
    		ArrayList<UserModel> usersList = UserService.selectAllUsers();
    		if(usersList.stream().filter(w->w.getName().equals(user.getName())).findAny().get() != null) throw new Exception();
    		if(usersList.stream().filter(w->w.getEmail().equals(user.getEmail())).findAny().get() != null) throw new Exception();
	        Session session = Database.openSession();
	        Transaction tx = session.beginTransaction();
	        session.save(user);
	        tx.commit();
	        session.close();
	        return true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
    }
}
