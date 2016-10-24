package com.paw.servertrello.lib;

import java.util.List;

/**
 * Created by Jakub on 2016-10-24.
 */
public class BoardAccess {
    private Long id;
    private Long userId;
    private Long boardId;


    public BoardAccess() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
