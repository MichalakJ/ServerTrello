package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.BoardModel;
import com.paw.servertrello.services.BoardService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.io.IOException;
import java.util.Collection;

@InterceptorRef("myStack")
public class BoardController implements ModelDriven<Object> 
{
    private BoardModel board = new BoardModel();
    private Long id;
    private Collection<BoardModel> list;

    public HttpHeaders show() 
    {
        board = BoardService.find(id);
        if(board==null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        if(board==null){
            return new DefaultHttpHeaders("create").withStatus(400);
        }

        String path= ServletActionContext.getRequest().getRequestURL().toString();
        try {
            long newBoardId = BoardService.save(board);
            ServletActionContext.getResponse().sendRedirect(path + "/" + Long.toString(newBoardId));
            return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newBoardId));
        } catch (Exception e) {
            return new DefaultHttpHeaders("create").withStatus(409);
        }

    }

//    public HttpHeaders index() {
//        list = BoardService.findAll();
//        return new DefaultHttpHeaders("index").disableCaching();
//    }

    public HttpHeaders destroy(){
        try {
            BoardService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultHttpHeaders("destroy").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(200);
    }

    public HttpHeaders update(){
        try {
            BoardService.update(board, id);
            return new DefaultHttpHeaders("update").disableCaching().withStatus(200);
        } catch (Exception e) {
            return new DefaultHttpHeaders("update").disableCaching().withStatus(409);
        }
    }

    @Override
    public Object getModel() {
        return (list != null ? list : board);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoardModel getBoard() {
        return board;
    }

    public void setBoard(BoardModel board) {
        this.board = board;
    }
}
