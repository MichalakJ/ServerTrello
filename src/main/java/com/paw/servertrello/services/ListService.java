package com.paw.servertrello.services;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.ListModel;

import java.util.ArrayList;

import org.hibernate.Session;

public class ListService 
{
    public static ArrayList<ListModel> getListsByBoardId(Long boardId) 
    {
    	return selectListsByBoardId(boardId);
    }

    public static ListModel find(Long listId) 
    {
    	return selectListById(listId);
    }
    
    public static ArrayList<ListModel> selectListsByBoardId(Long boardId)
    {
    	try
        {
			Session session = Database.openSession();
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
			Session session = Database.openSession();
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
    
}
