package com.paw.servertrello.lib;

import java.util.List;

/**
 * Created by Jakub on 2016-10-24.
 */
public class User {
    private Long id;
    private String fullname;
    private String name;
    private String email;
    private String about;
    private List<Long> boards;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public List<Long> getBoards() {
        return boards;
    }

    public void setBoards(List<Long> boards) {
        this.boards = boards;
    }
}
