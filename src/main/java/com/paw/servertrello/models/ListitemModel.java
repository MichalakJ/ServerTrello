package com.paw.servertrello.models;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.paw.servertrello.services.CommentService;

@Entity(name="ListItems")
public class ListitemModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long listItemId;
	private long listId;
	private String title;
	
	@Transient private ArrayList<CommentModel> commentsList;

    public ListitemModel(String title) 
    {
    	this.title = title;
    	commentsList = new ArrayList<CommentModel>();
    	commentsList = CommentService.getCommentsListByListItemId(listItemId);
    }

    public ListitemModel() {

    }
    
	public ArrayList<CommentModel> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(ArrayList<CommentModel> commentsList) {
		this.commentsList = commentsList;
	}
	
	public long getListItemId() {
		return listItemId;
	}

	public void setListItemId(long listItemId) {
		this.listItemId = listItemId;
	}

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
