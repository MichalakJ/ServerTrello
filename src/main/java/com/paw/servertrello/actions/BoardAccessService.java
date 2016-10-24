package com.paw.servertrello.actions;

import com.paw.servertrello.lib.BoardAccess;
import com.paw.servertrello.persistance.Converters.BoardAccessConverter;
import com.paw.servertrello.persistance.model.BoardAccessTable;

import java.util.*;

/**
 * Created by Jakub on 2016-10-24.
 */
public class BoardAccessService {
    public static Map accesses = new HashMap();
    public static long keyId;

    static{
        BoardAccessTable boardAccessTable = new BoardAccessTable();
        boardAccessTable.setId(++keyId);
        boardAccessTable.setBoardId(1L);
        boardAccessTable.setUserId(1L);
        accesses.put(keyId, boardAccessTable);
        BoardAccessTable boardAccessTable2 = new BoardAccessTable();
        boardAccessTable2.setId(++keyId);
        boardAccessTable2.setBoardId(2L);
        boardAccessTable2.setUserId(1L);
        accesses.put(keyId, boardAccessTable2);
    }

    public static Collection<BoardAccess> findAll() {
        return accesses.values();
    }

    public static long save(BoardAccess boardAccess) {
        BoardAccessTable boardAccessTable = BoardAccessConverter.convertFromDtoToEntity(boardAccess);
        boardAccessTable.setId(++keyId);
        accesses.put(keyId, boardAccessTable);
        return keyId;
    }

    public static void delete(Long id) {
        accesses.remove(id);
    }

    public static List<Long> getAccessesByBoardId(Long id) {
        List<Long> accessList = new ArrayList<>();
        for (Object value : accesses.values()) {
            BoardAccessTable boardAccessTable = (BoardAccessTable) value;
            if(boardAccessTable.getBoardId().equals(id)){
                accessList.add(boardAccessTable.getUserId());
            }
        }
        return accessList;
    }
}
