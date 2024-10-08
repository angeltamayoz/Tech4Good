package com.example.Tech4Good.CONTROLADORES;

import com.example.Tech4Good.MODELOS.User;
import com.example.Tech4Good.SERVICIOS.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("https://zorany26.github.io")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName){
        try {
            return new ResponseEntity<User>(userService.getUserByUserName(userName), HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Se produjo un error " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
