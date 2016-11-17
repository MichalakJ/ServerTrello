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
    		/////////////////////////sprawdzenie, czy jest juz taki użytkownik oraz czy wpisał hasło. Przy samym UNIQUE baza się crashuje
    		UserModel usersTest1 = UserService.selectUserByName(user.getName());
    		UserModel usersTest2 = UserService.selectUserByEmail(user.getEmail());
			if(usersTest1 != null || usersTest2 != null || user.getPass().equals("") || user.getPass() == null) throw new Exception();
    		////////////////////////
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
