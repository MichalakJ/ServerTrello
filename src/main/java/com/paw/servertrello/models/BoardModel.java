package com.paw.servertrello.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Boards")
public class BoardModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "boardId") private Long id;
    private String title;
    private String isFav;
    
    @Transient private ArrayList<ListModel> lists;

    public BoardModel(String title) 
    {
        this.title = title;
    }

    public BoardModel(){
    }
    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

	/**
	 * @return the isFav
	 */
	public String getIsFav() {
		return isFav;
	}

	/**
	 * @param isFav the isFav to set
	 */
	public void setIsFav(String isFav) {
		this.isFav = isFav;
	}
}
