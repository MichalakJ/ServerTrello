package com.paw.servertrello.models;

import javax.persistence.*;

@Entity(name="Comments")
public class CommentModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	private long userId, listItemId;
    private String text;
    private String addDate, editDate;
    
    
	@Transient
    private String author;
    
    public CommentModel(long id, long userId, long listItemId, String text, String author, String addDate, String editDate)
    {
    	this.id = id;
    	this.userId = userId;
    	this.listItemId = listItemId;
    	this.text = text;
    	this.author = author;
    	this.addDate = addDate;
    	this.editDate = editDate;
    }
    
    public CommentModel(){
    	
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the addDate
	 */
	public String getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	/**
	 * @return the editDate
	 */
	public String getEditDate() {
		return editDate;
	}

	/**
	 * @param editDate the editDate to set
	 */
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
}
