package com.paw.servertrello.services;

import java.util.ArrayList;

import org.hibernate.Session;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.UserModel;

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
	
	public static UserModel selectUserByName(String name)
	{
		try
		{
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where name = '"+name+"'").getResultList();
			UserModel user = usersList.get(0);
			user.setBoardsAccesses(BoardaccesstableService.getBoardAccessTableByUserId(user.getUserId()));
			session.close();
			return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<UserModel> selectAllUsers() 
	{
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>)session.createQuery("from Users").getResultList();
			for(int i=0; i<usersList.size(); i++)
			{
				usersList.get(i).setBoardsAccesses(BoardaccesstableService.getBoardAccessTableByUserId(usersList.get(i).getUserId()));
			}		
			session.close();
			return usersList;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static UserModel selectUserById(Long userId) 
	{
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where userId ="+userId).getResultList();
			UserModel user = usersList.get(0);
			//user.setBoardsList(BoardService.selectBoardsByUserId(user.getUserId()));
			user.setBoardsAccesses(BoardaccesstableService.getBoardAccessTableByUserId(user.getUserId()));
			session.close();
			return user;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static UserModel selectUserByEmail(String email)
	{
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where email ='"+email+"'").getResultList();
			UserModel user = usersList.get(0);
			user.setBoardsAccesses(BoardaccesstableService.getBoardAccessTableByUserId(user.getUserId()));
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
