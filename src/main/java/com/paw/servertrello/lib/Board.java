/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paw.servertrello.lib;

import java.util.List;

/**
 *
 * @author Jakub
 */
public class Board {
    private Long id;
    private String title;
    private List<CardList> lists;

    public Board(long id, String title, List<CardList> lists) {
        this.id = id;
        this.title = title;
        this.lists = lists;
    }

    public Board() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CardList> getLists() {
        return lists;
    }

    public void setLists(List<CardList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lists=" + lists +
                '}';
    }
}
