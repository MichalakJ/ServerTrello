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
    public static Map boards = new HashMap();
    public static long keyId;
    static{
        Card card1 = new Card(1, "card2");
        Card card2 = new Card(2, "card1");
        ArrayList<Card> cardList1 = new ArrayList<>();
        cardList1.add(card1);
        cardList1.add(card2);

        CardList cardList = new CardList(1, cardList1);

        ArrayList<CardList> cardLists= new ArrayList<>();

        cardLists.add(cardList);
        boards.put(++keyId, new Board(1, "boardTitle", cardLists));
        boards.put(++keyId, new Board(2, "boardTitle2", cardLists));
    }

    public static List findAll() {
        return new ArrayList(boards.values());
    }

    public static Board find(Long id) {
        return (Board)boards.get(id);
    }

    public static long save(Board board) {
        board.setId(++keyId);
        boards.put(keyId, board);
        return keyId;
    }
}
