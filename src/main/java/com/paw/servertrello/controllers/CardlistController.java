package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.actions.CardListService;
import com.paw.servertrello.lib.Board;
import com.paw.servertrello.lib.CardList;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardlistController implements ModelDriven<Object> {

    private static final long serialVersionUID = 89148916175417696L;
    private CardList cardList = new CardList();
    private Long id;
    private Collection<CardList> list;

    public HttpHeaders show() {
        cardList = CardListService.find(id);
        if(cardList==null){
            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        long newId = CardListService.save(cardList);
        String path= ServletActionContext.getRequest().getRequestURI();
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + Long.toString(newId));
    }

    public HttpHeaders destroy(){
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(CardListService.delete(id));
    }

    @Override
    public Object getModel() {
        return (list != null ? list : cardList);
    }

    public CardList getCardList() {
        return cardList;
    }

    public void setCardList(CardList cardList) {
        this.cardList = cardList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
