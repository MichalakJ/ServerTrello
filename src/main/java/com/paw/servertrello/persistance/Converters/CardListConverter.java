package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.CardList;
import com.paw.servertrello.persistance.model.CardListTable;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardListConverter {

    public static CardList convertFromEntityToDto(CardListTable cardListTable) {
        CardList cardList = new CardList();
        cardList.setId(cardListTable.getId());
        cardList.setBoardId(cardListTable.getBoardId());
        cardList.setTitle(cardListTable.getTitle());
        return cardList;

    }

    public static CardListTable convertFromDtoToEntity(CardList cardList) {
        CardListTable cardListTable = new CardListTable();
        cardListTable.setId(cardList.getId());
        cardListTable.setBoardId(cardList.getBoardId());
        cardListTable.setTitle(cardList.getTitle());
        return cardListTable;
    }
}
