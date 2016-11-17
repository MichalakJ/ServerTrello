package com.paw.servertrello.services;

import java.util.ArrayList;

import org.hibernate.Session;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.BoardModel;

public class BoardService 
{

    public static BoardModel find(Long boardId) 
    {
    	return selectBoardById(boardId);
    }

//    public static long save(BoardModel board) 
//    {
//
//    }
//
//    public static void delete(Long id) 
//    {
//
//    }
//
//    public static int update(BoardModel board, Long id) 
//    {
//
//    }
    
    public static ArrayList<BoardModel> selectBoardsByUserId(Long userId)
    {
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardModel> boardList = (ArrayList<BoardModel>) session.createQuery("from Boards p where userId ="+userId).getResultList();		
			for(int i =0; i<boardList.size(); i++)
			{
				long boardId = boardList.get(i).getBoardId();
				boardList.get(i).setLists(ListService.getListsByBoardId(boardId));
				boardList.get(i).setUsersAccesses(BoardaccesstableService.getBoardAccessTableByBoardId(boardId));
			}
			session.close();
			return boardList;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
    
    public static BoardModel selectBoardById(Long boardId)
    {
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardModel> boardList = (ArrayList<BoardModel>) session.createQuery("from Boards p where boardId ="+boardId).getResultList();		
			BoardModel board = boardList.get(0); //przyjmowanie list do boardów
			board.setLists(ListService.getListsByBoardId(board.getBoardId()));
			board.setUsersAccesses(BoardaccesstableService.getBoardAccessTableByBoardId(boardId));
			session.close();
			return board;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
//
}