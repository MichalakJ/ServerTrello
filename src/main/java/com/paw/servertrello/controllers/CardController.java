package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.CardListService;
import com.paw.servertrello.actions.CardService;
import com.paw.servertrello.lib.Card;
import com.paw.servertrello.lib.CardList;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

/**
 * Created by Jakub on 2016-10-24.
 */
@InterceptorRef("myStack")
public class CardController implements ModelDriven<Object> {

    private static final long serialVersionUID = 99142516175417696L;
    private Card card = new Card();
    private Long id;
    private Collection<Card> list;

    public HttpHeaders show() {
        System.out.println(id);
        card = CardService.find(id);
        if(card==null){
            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        long newId = CardService.save(card);
        String path= ServletActionContext.getRequest().getRequestURL().toString();
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
    }

    public HttpHeaders destroy(){
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(CardService.delete(id));
    }
    @Override
    public Object getModel() {
        return (list != null ? list : card);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Card> getList() {
        return list;
    }

    public void setList(Collection<Card> list) {
        this.list = list;
    }
}
