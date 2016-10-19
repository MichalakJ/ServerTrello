package com.paw.servertrello.actions;

import com.paw.servertrello.lib.Board;
import com.paw.servertrello.lib.Card;
import com.paw.servertrello.lib.CardList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jakub on 2016-10-19.
 */
public class BoardService {
    public static Map Boards = new HashMap();

    static{
        Card card1 = new Card(1, "card2");
        Card card2 = new Card(2, "card1");
        ArrayList<Card> cardList1 = new ArrayList<>();
        cardList1.add(card1);
        cardList1.add(card2);

        CardList cardList = new CardList(1, cardList1);

        ArrayList<CardList> cardLists= new ArrayList<>();

        cardLists.add(cardList);
        Boards.put("1", new Board(1, "boardTitle", cardLists));
        Boards.put("2", new Board(2, "boardTitle2", cardLists));
    }

    public static List findAll() {
        return new ArrayList(Boards.values());
    }

    public static Board find(String id) {
        return (Board)Boards.get(id);
    }
}
