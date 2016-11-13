package com.paw.servertrello.lib;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Comments")
public class CommentModel 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO) private long commentId;
    private long userId, listItemId;
    private String commentText;
    
    public CommentModel(long userId, long listItemId, String commentText)
    {
    	this.userId = userId;
    	this.listItemId = listItemId;
    	this.commentText = commentText;
    }
    
    public CommentModel(){
    	
    }
    
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getListItemId() {
		return listItemId;
	}
	public void setListItemId(long listItemId) {
		this.listItemId = listItemId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}


}
