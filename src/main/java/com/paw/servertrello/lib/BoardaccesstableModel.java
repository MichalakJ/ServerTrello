package com.paw.servertrello.lib;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="BoardAccessTable")
public class BoardaccesstableModel
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO) private long id;
    private long userId, boardId, accessLevel;

    public BoardaccesstableModel(long userId, long boardId, long accessLevel) 
    {
    	this.setUserId(userId);
    	this.setBoardId(boardId);
    	this.setAccessLevel(accessLevel);
    }
    
    public BoardaccesstableModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public long getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(long accessLevel) {
		this.accessLevel = accessLevel;
	}
}
