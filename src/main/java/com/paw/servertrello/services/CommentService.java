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
    	return Database.get(CommentModel.class, commentId);
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
    
    public static CommentModel selectCommentById(Long commentId) 
	{
    	try
        {
			String query= " select c.commentId, u.userId, c.listItemId, c.commentText, u.name, u.fullname from Comments c"
						+ " join Users u on u.userId = c.userId"
						+ " where c.commentId = "+commentId;		
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			List<Object[]> rawCommentsList = (List<Object[]>) session.createQuery(query).getResultList();
			ArrayList<CommentModel> commentsList = new ArrayList<CommentModel>();
			for (Object[] list : rawCommentsList) 
			{
				commentsList.add(new CommentModel((long)list[0],(long)list[1],(long)list[2],(String)list[3],(String)list[4],(String)list[5]));
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
			String query= " select c.commentId, u.userId, c.listItemId, c.commentText, u.name, u.fullname from Comments c"
						+ " join Users u on u.userId = c.userId"
						+ " where listItemId ="+listItemId;	
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			List<Object[]> rawCommentsList = (List<Object[]>) session.createQuery(query).getResultList();
			ArrayList<CommentModel> commentsList = new ArrayList<CommentModel>();
			for (Object[] list : rawCommentsList) 
			{
				commentsList.add(new CommentModel((long)list[0],(long)list[1],(long)list[2],(String)list[3],(String)list[4],(String)list[5]));
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
		comment.setCommentId(id);
		Database.update(comment);
	}
}
