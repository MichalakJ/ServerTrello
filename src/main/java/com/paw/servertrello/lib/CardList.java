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
public class CardList {
    long id;
    List<Card> listItems;

    public CardList(long id, List<Card> listItems) {
        this.id = id;
        this.listItems = listItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Card> getListItems() {
        return listItems;
    }

    public void setListItems(List<Card> listItems) {
        this.listItems = listItems;
    }
}
