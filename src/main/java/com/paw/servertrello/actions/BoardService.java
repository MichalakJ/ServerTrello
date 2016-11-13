package com.paw.servertrello.actions;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.lib.BoardModel;

public class BoardService 
{

    public static BoardModel find(Long boardId) 
    {
    	return Database.selectBoardById(boardId);
    }

//    public static long save(BoardModel board) 
//    {
//
//    }
//
//    public static void delete(Long id) 
//    {
//
//    }
//
//    public static int update(BoardModel board, Long id) 
//    {
//
//    }
}
