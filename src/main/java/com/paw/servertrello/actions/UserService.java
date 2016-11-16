package com.paw.servertrello.actions;

import java.util.ArrayList;

import org.hibernate.Session;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.lib.UserModel;

public class UserService 
{

	public static UserModel find(Long id) 
	{
		return selectUserById(id);
	}
//	
//	public static long save(UserModel user) 
//	{
//	
//	}
//	
//	public static Collection<UserModel> findAll() 
//	{
//	
//	}
//	
//	public static int delete(Long id) 
//	{
//	
//	}
	
	public static UserModel selectUserByName(String name) throws Exception
	{
		Session session = Database.openSession();
		@SuppressWarnings("unchecked")
		ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where name = '"+name+"'").getResultList();
		UserModel user = usersList.get(0);
		session.close();
		return user;
	}
	
	public static UserModel selectUserById(Long userId) 
	{
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where userId ="+userId).getResultList();
			UserModel user = usersList.get(0);
			session.close();
			return user;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
