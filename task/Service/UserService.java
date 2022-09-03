package com.api.task.Service;

import com.api.task.entity.*;
import com.api.task.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    PasswordEncoder passwordEncoder;

    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public UserService(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public List<User> getuser() {
        List<User> UserList = new ArrayList<>();
        userRepo.findAll().forEach(user -> UserList.add(user));
        return UserList;
    }

    // create

 /*   public User postUser(User user){
        return userRepo.save(user);
    }
*/
/*
      public Object postUser(User user) {
        try {
            userRepo.save(user);
             return "saved Successfully";
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return new ResponseErrorCreate(true, "user Already Exist");
                 } else {
                    return new ResponseErrorCreate(true, e.getMessage());
               }
        }
    }*/

    //working :)
 /*   public Object postUser(User user) {

        try {
            userRepo.save(user);
            return "save Successfully";
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return new ResponseErrorCreate("Already Exist");
            } else {
                return new ResponseErrorCreate("mention id");
            }
        }
    }*/

    public Object postUser(User user) {

        String encodePassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        try {
            userRepo.save(user);
            return "save Successfully";
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return new ResponseErrorCreate("Already Exist");
            } else {
                return new ResponseErrorCreate("mention id");
            }
        }
    }




 /*   public Object postUser(User user) {
        try {
            userRepo.save(user);
            return "saved Successfully";
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return new ResponseErrorCreate(true, "user Already Exist");
            } else {
                return new ResponseErrorCreate(true, e.getMessage());
            }
        }
   }*/


    // get by id
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    //update
    public Object updateUser(User user) {
        return userRepo.save(user);
    }


// delete by id working
  /*  public ResponseEntity<String> deleteById(Integer Id) {
        userRepo.deleteById(Id);
      //  return "Deleted Successfully";
        return new ResponseEntity<>("user is deleted successfully", HttpStatus.OK);
         //return ResponseEntity.status(200).body(new Delete200Response("User [" + Id + "] deleted"));
    }
*/

    // update by id
    public User updateUserById(Integer id, User user) {
        User findById = userRepo.findById(id).get();
        findById.setFirstName(user.getFirstName());
        findById.setLastName(user.getLastName());
        findById.setEmail(user.getEmail());
        findById.setPassword(user.getPassword());
        try {
            userRepo.save(findById);
        } catch (IllegalStateException e) {
            e.getLocalizedMessage();
        }
        return findById;
    }

  /*  public ResponseEntity<User> updateUserById(Integer id, User user) {
        User findById = userRepo.findById(id).get();
        findById.setFirstName(user.getFirstName());
        findById.setLastName(user.getLastName());
        findById.setEmail(user.getEmail());
        findById.setPassword(user.getPassword());
        try {
            return ResponseEntity.status(201).body(userRepo.save(findById));
        } catch (Exception e) {
            if(e.getMessage().contains(("ConstraintViolationException")){
                return ResponseEntity.status(403).body(new Create403Response("Access Denied"));
            }
        }
        return null;
    }*/


    //login
  /*  public Object loginUser(LoginRequest loginRequest) {

        return userRepo.loginuserdb(loginRequest.getEmail(), loginRequest.getPassword());
    }*/


    public Object login(LoginRequest loginResquest) {

        return userRepo.loginuserdb(loginResquest.getEmail(), loginResquest.getPassword());
    }

    public ResponseEntity<Object> deleteById(Integer id) {
        try {
            userRepo.deleteById(id);
            return ResponseEntity.status(200).body(new Delete200Response("User [" + id + "] deleted"));
        } catch (Exception e) {
            if (e.getMessage().contains("No class com.example.Organization.entity.user entity with id")) {
                return ResponseEntity.status(404).body(new Delete200Response("User [" + id + "] not found"));
            }
            return null;
        }
    }


}