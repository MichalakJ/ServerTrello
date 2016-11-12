package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.CommentService;
import com.paw.servertrello.lib.CardList;
import com.paw.servertrello.lib.Comment;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

/**
 * Created by Jakub on 2016-11-12.
 */
@InterceptorRef("myStack")
public class CommentController implements ModelDriven<Object> {
    private Comment comment = new Comment();
    private Long id;
    private Collection<Comment> list;

    public HttpHeaders show() {
        comment = CommentService.find(id);
        if (comment == null) {
            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        long newId = CommentService.save(comment);
        String path = ServletActionContext.getRequest().getRequestURL().toString();
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
    }

    public HttpHeaders destroy() {
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(CommentService.delete(id));
    }

    public HttpHeaders update() {
        return new DefaultHttpHeaders("update").disableCaching().withStatus(CommentService.update(id, comment));
    }

    @Override
    public Object getModel() {
        return (list != null ? list : comment);
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Comment> getList() {
        return list;
    }

    public void setList(Collection<Comment> list) {
        this.list = list;
    }
}
