package com.paw.servertrello.actions;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.lib.ListModel;
import java.util.ArrayList;

public class ListService 
{
    public static ArrayList<ListModel> getListsByBoardId(Long boardId) 
    {
    	return Database.selectListsByBoardId(boardId);
    }

    public static ListModel find(Long listId) 
    {
    	return Database.selectListById(listId);
    }
}
