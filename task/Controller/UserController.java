package com.api.task.Controller;


import com.api.task.Service.UserService;
import com.api.task.entity.*;
import com.api.task.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
//    private static Map<String, User> UserRepo = new HashMap<>();

    //get

    @GetMapping(value = "/users")
    public List<User> getuser() {
        return userService.getuser();
    }

    // post
  /*  @PostMapping(value = "/create")
    public ResponseEntity<Object> postUser(@RequestBody User user){
        Object create = userService.postUser(user);
        return ResponseEntity.status(201).body(create);
    }*/


   /* @PostMapping(value = "/create")
    public Object postUser(@RequestBody User user){
        Object obj = userService.postUser(user);
        return obj;
    }*/


    @PostMapping(value = "/create")
    public ResponseEntity<Object> postUser(@RequestBody User user) {
        Object create = userService.postUser(user);
        return ResponseEntity.status(201).body(create);
    }


  /*  @PostMapping(value = "create")
    public User postUser(@RequestBody User user)
    {
        return userService.postUser(user);
    }
*/


    //get by id

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") int id) {
        Optional<User> user = (userService.getUserById(id));
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(404).body(new Create403Response("user[" + id + "] not found"));
        }
    }

    // update

    @PutMapping(value = "/update")
    public Object updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // update by id working
/*
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable Integer id ,@RequestBody User user){
        User update = userService.updateUserById(id,user);
        return ResponseEntity.ok(update);
    }*/


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Integer id, @RequestBody User user) {

        try {
            User update = userService.updateUserById(id, user);
            return ResponseEntity.ok(update);
        } catch (Exception e) {
            if (e.getMessage().contains("no value present")) {
                return ResponseEntity.status(404).body(new Login404Response("user id :[" + id + "] Not found"));
            }
        }

        return null;
    }


    // delete by id
/*
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }*/

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }

    // login

    /*@PostMapping(value = "/user/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest) {
        try {

            Object user = userService.loginUser(loginRequest);

            if (user != null) {
                return ResponseEntity.status(200).body(user);
            } else {
                return ResponseEntity.status(404).body(new Login404Response("Email or Password does not Match"));
            }

        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }*/


    @PostMapping("/login")
    public ResponseEntity<Object> login( @RequestBody LoginRequest loginRequest, User user) throws Exception {

        User loginUser = (User) userService.login(loginRequest);
        Optional<User> logUser = Optional.ofNullable(loginUser);
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateJwt(loginUser);
        if (logUser.isPresent()) {

            return ResponseEntity.status(200).body(new TokenGen("Bearer", token));
        } else {
            return ResponseEntity.status(200).body(new EmailAndPasswordError("Email or password does not match"));
        }
    }


}

