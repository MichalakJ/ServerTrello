/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paw.servertrello.actions;

import com.paw.servertrello.lib.CardList;
import com.paw.servertrello.persistance.model.CardListTable;
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
        CardListTable cardListTable2 = new CardListTable(++keyId, 5L);
        cardLists.put(keyId, cardListTable2);
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

    public static CardList find(Long id) {
        CardListTable cardListTable = (CardListTable) cardLists.get(id);
        if(cardListTable == null){
            return null;
        }
        CardList cardList = CardListConverter.convertFromEntityToDto(cardListTable);
        cardList.setListItems(CardService.getCardsByListId(id));
        return cardList;
    }

    public static long save(CardList cardList) {
        CardListTable cardListTable = new CardListTable();
        cardListTable.setBoardId(cardList.getBoardId());
        cardListTable.setId(++keyId);
        cardLists.put(keyId, cardListTable);
        return keyId;
    }

    public static int delete(Long id) {
        if(cardLists.containsKey(id)){
            cardLists.remove(id);
            return 204;
        }
        return 404;

    }

    public static int update(Long id, CardList cardList) {
        if (!cardLists.containsKey(id)) {
            return 404;
        }
        CardListTable cardListTable = CardListConverter.convertFromDtoToEntity(cardList);
        cardLists.replace(id, cardListTable);
        return 200;
    }
}
