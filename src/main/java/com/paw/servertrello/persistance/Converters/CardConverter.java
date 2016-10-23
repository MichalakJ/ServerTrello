package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.Card;
import com.paw.servertrello.persistance.CardTable;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardConverter {
    public static Card convertFromEntityToDto(CardTable cardTable){
        Card card = new Card();
        card.setId(cardTable.getId());
        card.setTitle(cardTable.getTitle());
        return card;
    }
}
