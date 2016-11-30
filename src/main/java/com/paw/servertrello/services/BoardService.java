package com.paw.servertrello.services;

import java.util.ArrayList;
import java.util.List;

import com.paw.servertrello.models.ListModel;
import com.paw.servertrello.models.pojo.Archive;
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
			board.setLists(ListService.getListsByBoardId(board.getId()));
			board.setArchive(getArchivesLists(board.getId()));
			return board;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }

	private static Archive getArchivesLists(Long id) throws Exception {
		Session session = Database.openSession();
		ArrayList<ListModel> ListArray = (ArrayList<ListModel>) session.createQuery("from Lists p where boardId ="+id).getResultList();
		Archive archive = new Archive();
		ArrayList<Long> list = new ArrayList<>();
		for (ListModel listModel : ListArray) {
			if(listModel.getIsArchived()){
				list.add(listModel.getId());
			}
		}
		archive.setLists(list);
		session.close();
		return archive;
	}

	public static long save(BoardModel board) throws Exception {
		return Database.persist(board);
	}

	public static void delete(Long id) throws Exception {
		ListService.deleteByBoardId(id);
		BoardaccesstableService.deleteByBoardId(id);
		Database.delete(BoardModel.class, id);

	}

	public static void update(BoardModel board, Long id) throws Exception {
		board.setId(id);
		Database.update(board);
	}
//
}
