/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paw.servertrello.actions;

import com.paw.servertrello.lib.CardList;
import com.paw.servertrello.persistance.CardListTable;
import com.paw.servertrello.persistance.Converters.CardListConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jakub
 */
public class CardListService {
    public static Map cardLists = new HashMap();
    public static long keyId;
    static{
        CardListTable cardListTable = new CardListTable(++keyId, 1L);
        cardLists.put(keyId, cardListTable);
    }

    public static List<CardList> getListsByBoardId(long boardId){
        ArrayList<CardList> cardListsDto = new ArrayList<>();
        for (Object value : cardLists.values()) {
            CardListTable cardListTable = (CardListTable)value;
            if(cardListTable.getBoardId()==boardId){
                CardList cardList = CardListConverter.convertFromEntityToDto(cardListTable);
                cardList.setListItems(CardService.getCardsByListId(cardListTable.getId()));
                cardListsDto.add(cardList);

            }
        }

        return cardListsDto;
    }
}
