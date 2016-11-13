package com.paw.servertrello.actions;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.lib.ListitemModel;
import java.util.ArrayList;

public class ListItemService {

    public static ArrayList<ListitemModel> getListItemsByListId(long listId)
    {
    	return Database.selectListItemsByListId(listId);
    }

    public static ListitemModel find(Long listItemId) 
    {
    	return Database.selectListItemById(listItemId);
    }
}
