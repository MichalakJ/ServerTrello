package com.paw.servertrello.models.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub on 2016-11-28.
 */
public class Archive {
    private List<Long> lists = new ArrayList<>();
    private List<Long> items = new ArrayList<>();

    public List<Long> getLists() {
        return lists;
    }

    public void setLists(List<Long> lists) {
        this.lists = lists;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }
}
