package com.paw.servertrello.actions;

import com.paw.servertrello.lib.Card;
import com.paw.servertrello.persistance.CardTable;
import com.paw.servertrello.persistance.Converters.CardConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardService {

    public static Map cards = new HashMap();
    public static long keyId;
    static {
        CardTable card1 = new CardTable(++keyId, 1L,"card2");
        cards.put(keyId, card1);
        CardTable card2 = new CardTable(++keyId, 1L,"card1");
        cards.put(keyId, card2);

    }

    public static List<Card> getCardsByListId(Long id) {
        ArrayList<Card> cardList = new ArrayList<>();
        for (Object value : cards.values()) {
            CardTable card = (CardTable)value;
            if(card.getCardListId()==id){
                Card cardDto = CardConverter.convertFromEntityToDto(card);
                cardList.add(cardDto);
            }
        }
        return cardList;
    }
}
