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
			return Database.get(BoardModel.class, boardId);
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
		return Database.persist(board);
	}

	public static void delete(Long id) throws Exception {
		Database.delete(BoardModel.class, id);
	}

	public static void update(BoardModel board, Long id) throws Exception {
		board.setBoardId(id);
		Database.update(board);
	}
//
}
