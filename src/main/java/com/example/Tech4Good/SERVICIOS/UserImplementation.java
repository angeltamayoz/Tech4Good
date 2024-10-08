package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.User;
import com.example.Tech4Good.REPOSITORIOS.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByuserName(userName);
    }
}
