package com.paw.servertrello.services;

import java.util.ArrayList;

import org.hibernate.Session;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.BoardModel;
import org.hibernate.Transaction;

public class BoardService 
{

    public static BoardModel find(Long boardId) 
    {
    	return selectBoardByIdWithLists(boardId);
    }
    
    public static ArrayList<BoardModel> selectBoardsByUserId(Long userId)
    {
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardModel> boardList = (ArrayList<BoardModel>) session.createQuery("from Boards p where userId ="+userId).getResultList();		
			session.close();
			return boardList;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
    
    public static BoardModel selectBoardByIdWithoutLists(Long boardId)
    {
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardModel> boardList = (ArrayList<BoardModel>) session.createQuery("from Boards p where boardId ="+boardId).getResultList();		
			BoardModel board = boardList.get(0);
			session.close();
			return board;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
    
    public static BoardModel selectBoardByIdWithLists(Long boardId)
    {
    	try
        {
    		BoardModel board = selectBoardByIdWithoutLists(boardId);
			board.setLists(ListService.getListsByBoardId(board.getBoardId()));
			return board;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }

	public static long save(BoardModel board) throws Exception {
		Session session = Database.openSession();
		Transaction tx = session.beginTransaction();
		long id = (long) session.save(board);
		tx.commit();
		session.close();
		return id;
	}

	public static void delete(Long id) throws Exception {
		Session session = Database.openSession();
		Transaction tx = session.beginTransaction();
		BoardModel obj= (BoardModel)session.load(BoardModel.class,id);
		session.delete(obj);
		tx.commit();
		session.close();
	}

	public static void update(BoardModel board, Long id) throws Exception {
		board.setBoardId(id);
		Session session = Database.openSession();
		Transaction tx = session.beginTransaction();
		session.update(board);
		tx.commit();
		session.close();
	}
//
}
