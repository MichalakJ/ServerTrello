package com.paw.servertrello.persistance.model;

/**
 * Created by Jakub on 2016-11-12.
 */
public class CommentTable {
    private long id;
    private long cardId;
    private long userId;
    private String message;

    public CommentTable(long id, long cardId, long userId, String message) {
        this.id = id;
        this.cardId = cardId;
        this.userId = userId;
        this.message = message;
    }

    public CommentTable() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
