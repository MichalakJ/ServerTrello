package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.lib.BoardModel;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
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

//    public HttpHeaders create() {
//        if(board==null){
//            return new DefaultHttpHeaders("create").withStatus(400);
//        }
//        long newBoardId = BoardService.save(board);
//        String path= ServletActionContext.getRequest().getRequestURL().toString();
//        try {
//            ServletActionContext.getResponse().sendRedirect(path + "/" + Long.toString(newBoardId));
//        } catch (IOException e) {
//            return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newBoardId));
//        }
//        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newBoardId));
//    }
//
//    public HttpHeaders index() {
//        list = BoardService.findAll();
//        return new DefaultHttpHeaders("index").disableCaching();
//    }

//    public HttpHeaders destroy(){
//        BoardService.delete(id);
//        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(204);
//    }
//
//    public HttpHeaders update(){
//        return new DefaultHttpHeaders("update").disableCaching().withStatus(BoardService.update(board, id));
//    }
//
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
