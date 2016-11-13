package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.ListItemService;
import com.paw.servertrello.lib.ListitemModel;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

@InterceptorRef("myStack")
public class ListitemController implements ModelDriven<Object> 
{
    private ListitemModel cardList = new ListitemModel();
    private Long id;
    private Collection<ListitemModel> list;

    public HttpHeaders show() 
    {
        cardList = ListItemService.find(id);
        if(cardList==null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);     
        return new DefaultHttpHeaders("show").disableCaching();
    }

//    public HttpHeaders create() {
//        long newId = ListItemService.save(cardList);
//        String path= ServletActionContext.getRequest().getRequestURL().toString();
//        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
//    }
//
//    public HttpHeaders destroy(){
//        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(ListItemService.delete(id));
//    }
//
//    public HttpHeaders update(){
//        ListItemService.update(id, cardList);
//        return new DefaultHttpHeaders("update").disableCaching();
//    }

    @Override
    public Object getModel() {
        return (list != null ? list : cardList);
    }

    public ListitemModel getCardList() {
        return cardList;
    }

    public void setCardList(ListitemModel cardList) {
        this.cardList = cardList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
