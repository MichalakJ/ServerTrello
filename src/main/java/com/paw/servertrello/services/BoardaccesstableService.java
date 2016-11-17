package com.paw.servertrello.services;

import java.util.ArrayList;
import org.hibernate.Session;
import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.BoardaccesstableModel;

public class BoardaccesstableService 
{
	public static ArrayList<BoardaccesstableModel> getBoardAccessTableByBoardId(Long boardId) 
	{
    	try
        {
    		String query = "from BoardAccessTable p where boardId ="+boardId;
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardaccesstableModel> boardAccessTablesList = (ArrayList<BoardaccesstableModel>) session.createQuery(query).getResultList();
			session.close();
			return boardAccessTablesList;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<BoardaccesstableModel> getBoardAccessTableByUserId(Long userId) 
	{
    	try
        {
    		String query = "from BoardAccessTable p where userId ="+userId;
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardaccesstableModel> boardAccessTablesList = (ArrayList<BoardaccesstableModel>) session.createQuery(query).getResultList();
			session.close();
			return boardAccessTablesList;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
