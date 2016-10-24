package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardAccessService;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.lib.Board;
import com.paw.servertrello.lib.BoardAccess;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

/**
 * Created by Jakub on 2016-10-24.
 */
public class BoardsaccessController implements ModelDriven<Object>{
    private BoardAccess boardAccess = new BoardAccess();
    private Long id;
    private Collection<BoardAccess> list;

    public HttpHeaders index() {
        list = BoardAccessService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders create() {
        long newId = BoardAccessService.save(boardAccess);
        String path= ServletActionContext.getRequest().getRequestURL().toString();
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
    }

    public HttpHeaders destroy(){
        BoardAccessService.delete(id);
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(204);
    }

    @Override
    public Object getModel() {
        return (list != null ? list : boardAccess);
    }

    public BoardAccess getBoardAccess() {
        return boardAccess;
    }

    public void setBoardAccess(BoardAccess boardAccess) {
        this.boardAccess = boardAccess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BoardAccess> getList() {
        return list;
    }

    public void setList(Collection<BoardAccess> list) {
        this.list = list;
    }
}
