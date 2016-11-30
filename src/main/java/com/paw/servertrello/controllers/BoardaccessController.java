package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.BoardaccesstableModel;

import com.paw.servertrello.services.BoardaccesstableService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

@InterceptorRef("myStack")
public class BoardaccessController implements ModelDriven<Object> {
    private BoardaccesstableModel boardAccess = new BoardaccesstableModel();
    private Long id;
    private Collection<BoardaccesstableModel> list;

    //    public HttpHeaders index() {
//        list = BoardAccessService.findAll();
//        return new DefaultHttpHeaders("index").disableCaching();
//    }
//
    public HttpHeaders show() {
        try {
            boardAccess = BoardaccesstableService.find(id);
        } catch (Exception e) {
            if (boardAccess == null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        if (boardAccess == null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        if (boardAccess == null) {
            return new DefaultHttpHeaders("create").withStatus(400);
        }

        String path = ServletActionContext.getRequest().getRequestURL().toString();
        try {
            long newId = BoardaccesstableService.save(boardAccess);
            ServletActionContext.getResponse().sendRedirect(path + "/" + Long.toString(newId));
            return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultHttpHeaders("create").withStatus(409);
        }
    }

    public HttpHeaders destroy() {
        try {
            BoardaccesstableService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultHttpHeaders("destroy").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(200);
    }

    public HttpHeaders update() {
        try {
            BoardaccesstableService.update(boardAccess, id);
            return new DefaultHttpHeaders("update").disableCaching().withStatus(200);
        } catch (Exception e) {
            return new DefaultHttpHeaders("update").disableCaching().withStatus(409);
        }
    }

    @Override
    public Object getModel() {
        return (list != null ? list : boardAccess);
    }

    public BoardaccesstableModel getBoardAccess() {
        return boardAccess;
    }

    public void setBoardAccess(BoardaccesstableModel boardAccess) {
        this.boardAccess = boardAccess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BoardaccesstableModel> getList() {
        return list;
    }

    public void setList(Collection<BoardaccesstableModel> list) {
        this.list = list;
    }
}
