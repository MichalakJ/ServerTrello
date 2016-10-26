package com.paw.servertrello.controllers;


import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.lib.Board;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;


import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
 * Created by Jakub on 2016-10-19.
 */
@InterceptorRef("myStack")
public class BoardsController implements ModelDriven<Object> {


    private static final long serialVersionUID = 89268916175477696L;
    private Board board = new Board();
    private Long id;
    private Collection<Board> list;



    public HttpHeaders show() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);

        board = BoardService.find(id);
        if(board==null){
            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() throws IOException {
        if(board==null){
            return new DefaultHttpHeaders("create").withStatus(400);
        }
        long newBoardId = BoardService.save(board);
        String path= ServletActionContext.getRequest().getRequestURL().toString();
        ServletActionContext.getResponse().sendRedirect(path + "/" + Long.toString(newBoardId));
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newBoardId));
    }

    public HttpHeaders index() {
        list = BoardService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders destroy(){
        BoardService.delete(id);
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(204);
    }

    public HttpHeaders update(){
        return new DefaultHttpHeaders("update").disableCaching().withStatus(BoardService.update(board, id));
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
