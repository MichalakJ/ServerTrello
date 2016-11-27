package com.paw.servertrello.models;

import java.util.ArrayList;

import javax.persistence.Column;
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
    @Column(name = "hashColumn") private String hash;

    @Transient private ArrayList<BoardModel> boardsList;
    
    public UserModel(String fullname, String email, String name, String pass) 
    {
    	this.setFullname(fullname);
    	this.setEmail(email);
    	this.setName(name);
    	this.setPass(pass);
    	about = "";
    	profilePic = "";
    	boardsList = new ArrayList<BoardModel>();
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

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
}
