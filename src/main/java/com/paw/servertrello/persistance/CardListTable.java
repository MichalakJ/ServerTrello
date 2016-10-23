package com.paw.servertrello.persistance;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardListTable {
    private Long id;
    private Long boardId;

    public CardListTable(Long id, Long boardId) {
        this.id = id;
        this.boardId = boardId;
    }

    public CardListTable() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
