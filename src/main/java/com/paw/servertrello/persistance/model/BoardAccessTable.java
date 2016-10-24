package com.paw.servertrello.persistance.model;

/**
 * Created by Jakub on 2016-10-24.
 */
public class BoardAccessTable {
    private Long id;
    private Long userId;
    private Long boardId;

    public BoardAccessTable() {
    }

    public BoardAccessTable(Long id, Long userId, Long boardId) {
        this.id = id;
        this.userId = userId;
        this.boardId = boardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
