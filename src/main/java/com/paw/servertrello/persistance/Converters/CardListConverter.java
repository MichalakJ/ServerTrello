package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.CardList;
import com.paw.servertrello.persistance.CardListTable;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardListConverter {

    public static CardList convertFromEntityToDto(CardListTable cardListTable) {
        CardList cardList = new CardList();
        cardList.setId(cardListTable.getId());
        cardList.setBoardId(cardListTable.getBoardId());
        return cardList;

    }
}
