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
    private Board board = new Board();
    private Long id;
    private Collection<Board> list;



    public HttpHeaders show() {
        System.out.println("called "+id);
        board = BoardService.find(id);
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        if(board==null){
            return new DefaultHttpHeaders("create").withStatus(400);
        }
        long newBoardId = BoardService.save(board);
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(Long.toString(newBoardId));
    }

    public HttpHeaders index() {
        list = BoardService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
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
