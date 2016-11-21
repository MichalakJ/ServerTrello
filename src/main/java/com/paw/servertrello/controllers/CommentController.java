package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.models.CommentModel;
import com.paw.servertrello.services.CommentService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.io.IOException;
import java.util.Collection;

@InterceptorRef("myStack")
public class CommentController implements ModelDriven<Object> 
{
    private CommentModel comment = new CommentModel();
    private Long id;
    private Collection<CommentModel> list;

    public HttpHeaders show() 
    {
        try {
            comment = CommentService.find(id);
        } catch (Exception e) {
            return new DefaultHttpHeaders("show").disableCaching().withStatus(500);
        }
        if (comment == null) return new DefaultHttpHeaders("show").disableCaching().withStatus(404);   
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        String path= ServletActionContext.getRequest().getRequestURL().toString();
        long newId = 0;
        try {
            newId = CommentService.save(comment);
            ServletActionContext.getResponse().sendRedirect(path + "/" + Long.toString(newId));
        } catch (Exception e) {
            return new DefaultHttpHeaders("create").withStatus(409).setLocation(path + "/" + Long.toString(newId));
        }
        return new DefaultHttpHeaders("create").withStatus(409).setLocation(path + "/" + Long.toString(newId));

    }

    public HttpHeaders destroy() {
        try {
            CommentService.delete(id);
        } catch (Exception e) {
            return new DefaultHttpHeaders("create").withStatus(404);
        }
        return new DefaultHttpHeaders("create").withStatus(200);
    }

    public HttpHeaders update() {
        try {
            CommentService.update(comment, id);
            return new DefaultHttpHeaders("create").withStatus(200);
        } catch (Exception e) {
            return new DefaultHttpHeaders("update").withStatus(409);
        }
    }

    @Override
    public Object getModel() {
        return (list != null ? list : comment);
    }

    public CommentModel getComment() {
        return comment;
    }

    public void setComment(CommentModel comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<CommentModel> getList() {
        return list;
    }

    public void setList(Collection<CommentModel> list) {
        this.list = list;
    }
}
