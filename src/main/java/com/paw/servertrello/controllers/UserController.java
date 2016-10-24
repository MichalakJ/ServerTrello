package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.actions.BoardService;
import com.paw.servertrello.actions.UserService;
import com.paw.servertrello.lib.Board;
import com.paw.servertrello.lib.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;

/**
 * Created by Jakub on 2016-10-24.
 */
public class UserController implements ModelDriven<Object>{
    private User user = new User();
    private Long id;
    private Collection<User> list;

    public HttpHeaders show() {
        System.out.println(id);
        user = UserService.find(id);
        if(user==null){
            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
        }
        return new DefaultHttpHeaders("show").disableCaching();
    }

    public HttpHeaders create() {
        long newId = UserService.save(user);
        String path= ServletActionContext.getRequest().getRequestURL().toString();
        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
    }

    public HttpHeaders index() {
        list = UserService.findAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders destroy(){
        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(UserService.delete(id));
    }

    @Override
    public Object getModel() {
        return (list != null ? list : user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<User> getList() {
        return list;
    }

    public void setList(Collection<User> list) {
        this.list = list;
    }
}
