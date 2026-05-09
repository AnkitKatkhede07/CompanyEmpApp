package com.service;

import com.model.Users;
import com.repsitory.UserDAO;

public class UserService {

    UserDAO dao = new UserDAO();

    public boolean register(Users user) {
        return dao.register(user);
    }
}