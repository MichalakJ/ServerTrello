package com.paw.servertrello.models;

import java.util.ArrayList;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Users")
public class UserModel 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long userId;
    private String fullname, email, about, profilePic, name, pass;

    @Transient private ArrayList<BoardModel> boardsList;
    @Transient private ArrayList<BoardaccesstableModel> boardsAccesses;
    
    public UserModel(String fullname, String email, String name, String pass) 
    {
    	this.setFullname(fullname);
    	this.setEmail(email);
    	this.setName(name);
    	this.setPass(pass);
    	about = "";
    	profilePic = "";
    	boardsList = new ArrayList<BoardModel>();
    	boardsAccesses = new ArrayList<BoardaccesstableModel>();
    }
 
    public UserModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public ArrayList<BoardModel> getBoardsList() {
		return boardsList;
	}

	public void setBoardsList(ArrayList<BoardModel> boardsList) {
		this.boardsList = boardsList;
	}

	public ArrayList<BoardaccesstableModel> getBoardsAccesses() {
		return boardsAccesses;
	}

	public void setBoardsAccesses(ArrayList<BoardaccesstableModel> boardsAccesses) {
		this.boardsAccesses = boardsAccesses;
	}

}