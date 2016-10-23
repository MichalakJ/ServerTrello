package com.paw.servertrello.persistance;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardTable {
    private Long id;
    private Long cardListId;
    private String title;

    public CardTable(Long id, Long cardListId, String title) {
        this.id = id;
        this.cardListId = cardListId;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardListId() {
        return cardListId;
    }

    public void setCardListId(Long cardListId) {
        this.cardListId = cardListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
