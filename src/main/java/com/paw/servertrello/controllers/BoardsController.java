package com.paw.servertrello.controllers;


import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.lib.Board;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;


import java.util.Collection;

/**
 * Created by Jakub on 2016-10-19.
 */
public class BoardsController implements ModelDriven<Object> {


    private static final long serialVersionUID = 89268916175477696L;
    private Board model = new Board();
    private String id;
    private Collection<Board> list;



    public HttpHeaders show() {
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders update() {
        //BoardService.save(model);
        return new DefaultHttpHeaders("update");
    }

    public HttpHeaders index() {
        list = BoardService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    @Override
    public Object getModel() {
        return (list != null ? list : model);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null) {
            this.model = BoardService.find(id);
        }
        this.id = id;
    }
}
