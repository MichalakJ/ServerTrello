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

    public static Card find(Long id) {
        Card card;
        if(!cards.containsKey(id)){
            return null;
        }
        card = CardConverter.convertFromEntityToDto((CardTable) cards.get(id));
        return card;
    }

    public static long save(Card card) {
        CardTable cardTable = CardConverter.convertFromDtoToEntity(card);
        cardTable.setId(++keyId);
        cards.put(keyId, cardTable);
        return keyId;
    }

    public static int delete(Long id) {
        if(!cards.containsKey(id)){
            return 404;
        }
        cards.remove(id);
        return 204;
    }
}
