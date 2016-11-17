package com.paw.servertrello.services;

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
