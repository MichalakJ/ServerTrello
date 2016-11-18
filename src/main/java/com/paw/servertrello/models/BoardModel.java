package com.paw.servertrello.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Boards")
public class BoardModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long boardId;
    private String title;
    @Transient private ArrayList<ListModel> lists;

    public BoardModel(String title) 
    {
        this.title = title;
    }

    public BoardModel(){
    }
    
    public Long getBoardId() {
        return boardId;
    }


    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


	public List<ListModel> getLists() {
		return lists;
	}

	public void setLists(ArrayList<ListModel> lists) {
		this.lists = lists;
	}
}
