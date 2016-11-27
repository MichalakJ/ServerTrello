package com.paw.servertrello.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.paw.servertrello.services.CommentService;

@Entity(name="ListItems")
public class ListitemModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "listItemId") private Long id;
	private long listId;
	private String title, labels, schedule;
	
	@Transient private ArrayList<CommentModel> commentsList;
	
    public ListitemModel(String title) 
    {
    	this.title = title;
    	commentsList = new ArrayList<CommentModel>();
    	commentsList = CommentService.getCommentsListByListItemId(id);
    }

    public ListitemModel() {

    }
    
	public ArrayList<CommentModel> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(ArrayList<CommentModel> commentsList) {
		this.commentsList = commentsList;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	/**
	 * @return the labels
	 */
	public String getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(String labels) {
		this.labels = labels;
	}

	/**
	 * @return the schedule
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}


}
