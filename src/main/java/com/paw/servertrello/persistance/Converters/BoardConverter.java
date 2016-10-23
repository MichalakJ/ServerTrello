package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.Board;
import com.paw.servertrello.persistance.BoardTable;

/**
 * Created by Jakub on 2016-10-23.
 */
public class BoardConverter {
    public static Board convertFromEntityToDto(BoardTable boardTable){
        Board board = new Board();
        board.setId(boardTable.getId());
        board.setTitle(boardTable.getTitle());
        return board;
    }
}
