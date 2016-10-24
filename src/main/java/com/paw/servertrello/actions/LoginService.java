package com.paw.servertrello.actions;

import com.paw.servertrello.lib.Credentials;
import com.paw.servertrello.lib.User;

/**
 * Created by Jakub on 2016-10-24.
 */
public class LoginService {
    public static User login(Credentials credentials){
        return UserService.getUser(credentials.getLogin());
    }
}
