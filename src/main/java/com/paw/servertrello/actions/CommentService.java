package com.paw.servertrello.actions;

import java.util.ArrayList;
import com.paw.servertrello.database.Database;
import com.paw.servertrello.lib.CommentModel;

public class CommentService
{
    public static ArrayList<CommentModel> getCommentsListByListItemId(long listItemId)
    {
    	return Database.selectCommentsListByListItemId(listItemId);
    }
    
    public static CommentModel find(Long commentId) 
    {
    	return Database.selectCommentById(commentId);
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
}
