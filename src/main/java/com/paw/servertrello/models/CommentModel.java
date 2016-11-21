package com.paw.servertrello.models;

import javax.persistence.*;

@Entity(name="Comments")
public class CommentModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private long commentId;
    private long userId, listItemId;
    private String commentText;

	@Transient
    private String name;
	@Transient
    private String fullname;
    
    public CommentModel(long commentId, long userId, long listItemId, String commentText, String name, String fullname)
    {
    	this.userId = userId;
    	this.listItemId = listItemId;
    	this.commentText = commentText;
    	this.name = name;
    	this.fullname = fullname;
    }
    
    public CommentModel(){
    	
    }
    
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
