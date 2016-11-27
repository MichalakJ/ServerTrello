package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.ListitemModel;
import com.paw.servertrello.services.ListItemService;

import org.apache.struts2.ServletActionContext;
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

    public HttpHeaders create() {
        if (cardList == null) {
            return new DefaultHttpHeaders("create").withStatus(400);
        }

        String path = ServletActionContext.getRequest().getRequestURL().toString();
        try {
            long newId = ListItemService.save(cardList);
            ServletActionContext.getResponse().sendRedirect(path + "/" + Long.toString(newId));
            return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
        } catch (Exception e) {
            return new DefaultHttpHeaders("create").withStatus(409);
        }
    }

    public HttpHeaders destroy(){
        try {
            ListItemService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultHttpHeaders("destroy").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(200);
    }

    public HttpHeaders update(){
        try {
            ListItemService.update(cardList, id);
            return new DefaultHttpHeaders("update").disableCaching().withStatus(200);
        } catch (Exception e) {
            return new DefaultHttpHeaders("update").disableCaching().withStatus(409);
        }
    }

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
