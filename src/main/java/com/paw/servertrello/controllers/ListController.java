package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.ListService;
import com.paw.servertrello.lib.ListModel;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

@InterceptorRef("myStack")
public class ListController implements ModelDriven<Object> 
{
    private ListModel card = new ListModel();
    private Long id;
    private Collection<ListModel> list;

    public HttpHeaders show() 
    {
        System.out.println(id);
        card = ListService.find(id);
        if(card==null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);  
        return new DefaultHttpHeaders("show").disableCaching();
    }

//    public HttpHeaders create() {
//        long newId = ListService.save(card);
//        String path= ServletActionContext.getRequest().getRequestURL().toString();
//        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
//    }
//
//    public HttpHeaders destroy(){
//        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(ListService.delete(id));
//    }
    
    @Override
    public Object getModel() {
        return (list != null ? list : card);
    }

    public ListModel getCard() {
        return card;
    }

    public void setCard(ListModel card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<ListModel> getList() {
        return list;
    }

    public void setList(Collection<ListModel> list) {
        this.list = list;
    }
}
