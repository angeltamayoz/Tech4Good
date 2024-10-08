package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.Donors;
import com.example.Tech4Good.MODELOS.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public User getUserByUserName(String userName);
}
