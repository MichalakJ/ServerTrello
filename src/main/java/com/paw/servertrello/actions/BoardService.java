package com.paw.servertrello.actions;

import com.paw.servertrello.lib.Board;
import com.paw.servertrello.persistance.model.BoardTable;
import com.paw.servertrello.persistance.Converters.BoardConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jakub on 2016-10-19.
 */
public class BoardService {
    public static Map boards = new HashMap();
    public static long keyId;
    static{
        boards.put(++keyId, new BoardTable(1L, "boardTitle"));
        boards.put(++keyId, new BoardTable(2L, "boardTitle2"));
    }

    public static List findAll() {
        return new ArrayList(boards.values());
    }

    public static Board find(Long id) {
        BoardTable boardTable = (BoardTable)boards.get(id);
        if(boardTable==null){
            return null;
        }
        Board board = BoardConverter.convertFromEntityToDto(boardTable);
        board.setLists(CardListService.getListsByBoardId(id));
        board.setUsersAccesses(BoardAccessService.getAccessesByBoardId(id));
        return board;
    }

    public static long save(Board board) {
        BoardTable boardTable = new BoardTable(++keyId, board.getTitle());
        boards.put(keyId, boardTable);
        return keyId;
    }

    public static void delete(Long id) {
        boards.remove(id);
    }

    public static int update(Board board, Long id) {
        if(!boards.containsKey(id)){
            return 404;
        }
        boards.replace(id, new BoardTable(id, board.getTitle()));
        return 200;
    }
}
