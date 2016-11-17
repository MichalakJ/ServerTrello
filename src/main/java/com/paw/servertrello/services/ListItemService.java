package com.paw.servertrello.services;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.ListitemModel;

import java.util.ArrayList;

import org.hibernate.Session;

public class ListItemService {

    public static ArrayList<ListitemModel> getListItemsByListId(long listId)
    {
    	return selectListItemsByListId(listId);
    }

    public static ListitemModel find(Long listItemId) 
    {
    	return selectListItemById(listItemId);
    }
    
    public static ArrayList<ListitemModel> selectListItemsByListId(Long listId)
    {
    	try
        {
			Session session = Database.openSession();
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
			Session session = Database.openSession();
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

}
