package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.User;
import com.paw.servertrello.persistance.model.UserTable;

/**
 * Created by Jakub on 2016-10-24.
 */
public class UserConverter {
    public static User convertFromEntityToDto(UserTable userTable){
        User user = new User();
        user.setAbout(userTable.getAbout());
        user.setEmail(userTable.getEmail());
        user.setFullname(userTable.getFullname());
        user.setId(userTable.getId());
        user.setName(userTable.getName());
        return user;
    }

    public static UserTable convertFromDtoToEntity(User user) {
        UserTable userTable = new UserTable();
        userTable.setAbout(user.getAbout());
        userTable.setName(user.getName());
        userTable.setEmail(user.getEmail());
        userTable.setFullname(user.getFullname());
        userTable.setId(user.getId());
        return userTable;
    }
}
