package com.paw.servertrello.actions;

import com.paw.servertrello.lib.BoardAccess;
import com.paw.servertrello.lib.User;
import com.paw.servertrello.persistance.Converters.UserConverter;
import com.paw.servertrello.persistance.model.UserTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jakub on 2016-10-24.
 */
public class UserService {
    public static Map users = new HashMap();
    public static long keyId;
    static{
        UserTable userTable = new UserTable();
        userTable.setId(++keyId);
        userTable.setName("testUser");
        userTable.setFullname("test user the mighty");
        userTable.setAbout("kisne z tym serwerem");
        userTable.setEmail("a@b.com");
        users.put(keyId, userTable);
    }

    public static User find(Long id) {
        if(!users.containsKey(id)){
            return null;
        }
        User user = UserConverter.convertFromEntityToDto((UserTable)users.get(id));
        user.setBoards(BoardAccessService.getAccessesByUserId(id));
        return user;
    }

    public static long save(User user) {
        UserTable userTable = UserConverter.convertFromDtoToEntity(user);
        userTable.setId(++keyId);
        users.put(keyId, userTable);
        return keyId;
    }

    public static Collection<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        for (Object value : users.values()) {
            UserTable userTable = (UserTable) value;
            User user = UserConverter.convertFromEntityToDto(userTable);
            user.setBoards(BoardAccessService.getAccessesByUserId(user.getId()));
            userList.add(user);
        }
        return userList;
    }

    public static int delete(Long id) {
        if(!users.containsKey(id)){
            return 404;
        }
        users.remove(id);
        return 204;
    }
}
