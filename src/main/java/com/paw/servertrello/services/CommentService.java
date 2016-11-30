package com.paw.servertrello.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.CommentModel;

public class CommentService
{
    public static ArrayList<CommentModel> getCommentsListByListItemId(long listItemId)
    {
    	return selectCommentsListByListItemId(listItemId);
    }
    
    public static CommentModel find(Long commentId) throws Exception {
    	return selectCommentById(commentId);
    }

//    public static long save(CommentModel comment) 
//    {
//
//    }
//
//    public static int delete(Long id) 
//    {
//
//    }
//
//    public static int update(Long id, CommentModel comment) 
//    {
//
//    }
    
    public static CommentModel selectCommentById(Long id) 
	{
    	try
        {
			String query= " select c.id, u.userId, c.listItemId, c.text, u.fullname, u.name, c.addDate, c.editDate from Comments c"
						+ " join Users u on u.userId = c.userId"
						+ " where c.id = "+id;		
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			List<Object[]> rawCommentsList = (List<Object[]>) session.createQuery(query).getResultList();
			ArrayList<CommentModel> commentsList = new ArrayList<CommentModel>();
			for (Object[] list : rawCommentsList) 
			{
				long commentId = (long)list[0];
				long userId = (long)list[1];
				long listItemId = (long)list[2];
				String text = (String)list[3];
				String author = (String)list[4] + " ("+(String)list[5]+")";
				String addDate = (String)list[6];
				String editDate = (String)list[7];
				commentsList.add(new CommentModel(commentId, userId, listItemId, text, author, addDate, editDate));
			
			}
			session.close();
			return commentsList.get(0);
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
			String query= " select c.id, u.userId, c.listItemId, c.text, u.fullname, u.name, c.addDate, c.editDate from Comments c"
						+ " join Users u on u.userId = c.userId"
						+ " where listItemId ="+listItemId;	
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			List<Object[]> rawCommentsList = (List<Object[]>) session.createQuery(query).getResultList();
			ArrayList<CommentModel> commentsList = new ArrayList<CommentModel>();
			for (Object[] list : rawCommentsList) 
			{
				long commentId = (long)list[0];
				long userId = (long)list[1];
				String text = (String)list[3];
				String author = (String)list[4] + " ("+(String)list[5]+")";
				String addDate = (String)list[6];
				String editDate = (String)list[7];
				commentsList.add(new CommentModel(commentId, userId, listItemId, text, author, addDate, editDate));
			}
			session.close();
			return commentsList;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

    public static long save(CommentModel comment) throws Exception {
		return Database.persist(comment);
    }

	public static void delete(Long id) throws Exception {
		Database.delete(CommentModel.class, id);
	}


	public static void update(CommentModel comment, Long id) throws Exception {
		comment.setId(id);
		Database.update(comment);
	}

    public static void deleteByListItemId(Long id) throws Exception {

		Session session = Database.openSession();
		ArrayList<CommentModel> comments = (ArrayList<CommentModel>) session.createQuery("from Comments p where listItemId ="+id).getResultList();
		for (CommentModel comment : comments) {
			delete(comment.getId());
		}
		session.close();
    }
}
