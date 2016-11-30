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


	public static long save(BoardaccesstableModel board) throws Exception {
		return Database.persist(board);
	}

	public static void delete(Long id) throws Exception {
		Database.delete(BoardaccesstableModel.class, id);
	}

	public static void update(BoardaccesstableModel board, Long id) throws Exception {
		board.setId(id);
		Database.update(board);
	}

	public static BoardaccesstableModel find(Long id) throws Exception {
		return Database.get(BoardaccesstableModel.class, id);
	}

	public static void deleteByBoardId(Long id) throws Exception {
		Session session = Database.openSession();
		ArrayList<BoardaccesstableModel> accesses = (ArrayList<BoardaccesstableModel>) session.createQuery("from BoardAccessTable p where boardId ="+id).getResultList();
		for (BoardaccesstableModel access : accesses) {
			delete(access.getId());
		}
		session.close();
	}
}
