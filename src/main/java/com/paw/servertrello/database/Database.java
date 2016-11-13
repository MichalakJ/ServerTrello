package com.paw.servertrello.database;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.paw.servertrello.actions.CommentService;
import com.paw.servertrello.actions.ListItemService;
import com.paw.servertrello.actions.ListService;
import com.paw.servertrello.lib.BoardModel;
import com.paw.servertrello.lib.CommentModel;
import com.paw.servertrello.lib.ListitemModel;
import com.paw.servertrello.lib.ListModel;

public class Database 
{
    private static Session openSession() throws Exception
    {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
        return sessionFactory.openSession();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public static BoardModel selectBoardById(Long boardId)
    {
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<BoardModel> boardList = (ArrayList<BoardModel>) session.createQuery("from Boards p where boardId ="+boardId).getResultList();		
			BoardModel board = boardList.get(0); //przyjmowanie list do boardów
			board.setLists(ListService.getListsByBoardId(board.getBoardId()));
			session.close();
			return board;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<ListModel> selectListsByBoardId(Long boardId)
    {
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<ListModel> listsInBoard = (ArrayList<ListModel>) session.createQuery("from Lists p where boardId ="+boardId).getResultList();	
			for(int i=0; i<listsInBoard.size(); i++) //przyjmowanie listItemów do list
			{
				listsInBoard.get(i).setListItems(ListItemService.getListItemsByListId(listsInBoard.get(i).getListId()));
			}
			session.close();
			return listsInBoard;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
    
    public static ListModel selectListById(Long listId)
    {
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<ListModel> listsInBoard = (ArrayList<ListModel>) session.createQuery("from Lists p where listId ="+listId).getResultList();
			ListModel list = listsInBoard.get(0);
			list.setListItems(ListItemService.getListItemsByListId(list.getListId()));
			session.close();
			return list;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<ListitemModel> selectListItemsByListId(Long listId)
    {
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<ListitemModel> listItems = (ArrayList<ListitemModel>) session.createQuery("from ListItems p where listId ="+listId).getResultList();
			for(int i=0; i<listItems.size(); i++) //przyjmowanie komentarzy do listItemów
			{
				listItems.get(i).setCommentsList(CommentService.getCommentsListByListItemId(listItems.get(i).getListItemId()));
			}
			session.close();
			return listItems;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
    
    public static ListitemModel selectListItemById(Long listItemId)
    {
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<ListitemModel> listItems = (ArrayList<ListitemModel>) session.createQuery("from ListItems p where listItemId ="+listItemId).getResultList();
			ListitemModel listItem = listItems.get(0);
			listItem.setCommentsList(CommentService.getCommentsListByListItemId(listItem.getListId()));
			session.close();
			return listItem;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
	public static CommentModel selectCommentById(Long commentId) 
	{
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<CommentModel> commentsList = (ArrayList<CommentModel>) session.createQuery("from Comments p where commentId ="+commentId).getResultList();
			CommentModel comment = commentsList.get(0);
			session.close();
			return comment;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<CommentModel> selectCommentsListByListItemId(long listItemId) 
	{
    	try
        {
			Session session = openSession();
			@SuppressWarnings("unchecked")
			ArrayList<CommentModel> comments = (ArrayList<CommentModel>) session.createQuery("from Comments p where listItemId ="+listItemId).getResultList();
			session.close();
			return comments;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////


}
