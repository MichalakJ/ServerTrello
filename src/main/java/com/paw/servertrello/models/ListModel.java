package com.paw.servertrello.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.paw.servertrello.services.ListItemService;

@Entity(name="Lists")
public class ListModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private long listId;
    private long boardId;
    private String title;
    private boolean isArchived;
    
    @Transient private ArrayList<ListitemModel> listItems;

    public ListModel(long boardId, String title, boolean isArchived) 
    {
        this.title = title;
        this.boardId = boardId;
		this.isArchived = isArchived;
		listItems = new ArrayList<ListitemModel>();
		listItems = ListItemService.getListItemsByListId(listId);
    }

    public ListModel() {
    }

    public boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}
	
	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	
	public List<ListitemModel> getListItems() {
		return listItems;
	}

	public void setListItems(ArrayList<ListitemModel> listItems) {
		this.listItems = listItems;
	}
}
