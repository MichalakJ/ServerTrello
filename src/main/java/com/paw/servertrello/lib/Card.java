/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paw.servertrello.lib;

/**
 *
 * @author Jakub
 */
public class Card {
    private long id;
    private String title;
    private long cardListId;

    public Card(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Card() {

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

    public long getCardListId() {
        return cardListId;
    }
    //
    public void setCardListId(long cardListId) {
        this.cardListId = cardListId;
    }
}
