package com.paw.servertrello.controllers;

import com.opensymphony.xwork2.ModelDriven;
import com.paw.servertrello.lib.UserModel;
import org.apache.struts2.convention.annotation.InterceptorRef;


import java.util.Collection;

@InterceptorRef("myStack")
public class UserController implements ModelDriven<Object>{
    private UserModel user = new UserModel();
    private Long id;
    private Collection<UserModel> list;

//    public HttpHeaders show() {
//        System.out.println(id);
//        user = UserService.find(id);
//        if(user==null){
//            return new DefaultHttpHeaders("show").disableCaching().withStatus(404);
//        }
//        return new DefaultHttpHeaders("show").disableCaching();
//    }

//    public HttpHeaders create() {
//        long newId = UserService.save(user);
//        String path= ServletActionContext.getRequest().getRequestURL().toString();
//        return new DefaultHttpHeaders("create").withStatus(201).setLocation(path + "/" + Long.toString(newId));
//    }
//
//    public HttpHeaders index() {
//        list = UserService.findAll();
//        return new DefaultHttpHeaders("index").disableCaching();
//    }
//
//    public HttpHeaders destroy(){
//        return new DefaultHttpHeaders("destroy").disableCaching().withStatus(UserService.delete(id));
//    }

    @Override
    public Object getModel() {
        return (list != null ? list : user);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<UserModel> getList() {
        return list;
    }

    public void setList(Collection<UserModel> list) {
        this.list = list;
    }
}
