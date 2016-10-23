package com.paw.servertrello.persistance;

/**
 * Created by Jakub on 2016-10-23.
 */
public class BoardTable {
    private Long id;
    private String title;

    public BoardTable(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
