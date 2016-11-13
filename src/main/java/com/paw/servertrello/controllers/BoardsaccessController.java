package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.lib.BoardAccessModel;
import org.apache.struts2.convention.annotation.InterceptorRef;
import java.util.Collection;

@InterceptorRef("myStack")
public class BoardsaccessController implements ModelDriven<Object>{
    private BoardAccessModel boardAccess = new BoardAccessModel();
    private Long id;
    private Collection<BoardAccessModel> list;

//    public HttpHeaders index() {
//        list = BoardAccessService.findAll();
//        return new DefaultHttpHeaders("index").disableCaching();
//    }
//
//    public HttpHeaders create() {
//        long newId = BoardAccessService.save(boardAccess);
//        String path= ServletActionContext.getRequest().getRequestURL().toString();
//        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
//    }
//
//    public HttpHeaders destroy(){
//        BoardAccessService.delete(id);
//        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(204);
//    }

    @Override
    public Object getModel() {
        return (list != null ? list : boardAccess);
    }

    public BoardAccessModel getBoardAccess() {
        return boardAccess;
    }

    public void setBoardAccess(BoardAccessModel boardAccess) {
        this.boardAccess = boardAccess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BoardAccessModel> getList() {
        return list;
    }

    public void setList(Collection<BoardAccessModel> list) {
        this.list = list;
    }
}
