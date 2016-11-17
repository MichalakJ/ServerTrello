package com.paw.servertrello.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.paw.servertrello.services.ListService;

@Entity(name="Boards")
public class BoardModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long boardId;
    private Long userId;
    private String title;
    
    @Transient private ArrayList<ListModel> lists;
    @Transient private ArrayList<BoardaccesstableModel> usersAccesses;

    public BoardModel(Long userId, String title) 
    {
        this.title = title;
    	lists = new ArrayList<ListModel>();
        lists = ListService.getListsByBoardId(boardId);
    }

    public BoardModel() 
    {
    }
    
    public Long getBoardId() {
        return boardId;
    }


    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    
    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
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

	public ArrayList<BoardaccesstableModel> getUsersAccesses() {
		return usersAccesses;
	}

	public void setUsersAccesses(ArrayList<BoardaccesstableModel> usersAccesses) {
		this.usersAccesses = usersAccesses;
	}
}
