package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.BoardAccess;
import com.paw.servertrello.persistance.model.BoardAccessTable;

/**
 * Created by Jakub on 2016-10-24.
 */
public class BoardAccessConverter {
    public static BoardAccessTable convertFromDtoToEntity(BoardAccess boardAccess){
        BoardAccessTable boardAccessTable = new BoardAccessTable();
        boardAccessTable.setBoardId(boardAccess.getBoardId());
        boardAccessTable.setUserId(boardAccess.getUserId());
        boardAccessTable.setId(boardAccess.getId());
        return boardAccessTable;
    }
}
