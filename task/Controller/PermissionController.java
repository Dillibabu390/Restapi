package com.api.task.Controller;


import com.api.task.Service.PermissionService;
import com.api.task.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    //List
    @GetMapping(value = "/api/permissions")
    public List<Permission> getPermission() {
        return permissionService.getPermission();
    }

    //Get by id
    @GetMapping(value = "/api/permissions/{id}")
    public ResponseEntity<Object> getPermissionById(@PathVariable("id") int id) {
        Optional<Permission> user = (permissionService.getPermissionById(id));
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(404).body(new Create403Response("user[" + id + "] not found"));
        }
    }


    //create
    @PostMapping(value = "/api/permissions")
    public ResponseEntity<Object> postStudent(@RequestBody Permission permission) {
        Object create = permissionService.postStudent(permission);
        return ResponseEntity.status(201).body(create);
    }

    //Delete
    @DeleteMapping(value = "/api/permissions/{id}")
    public ResponseEntity<Object> PermissiondeleteById(@PathVariable Integer id) {
        return permissionService.PermissiondeleteById(id);
    }


    //update by id
    @PutMapping(value = "/api/permissions/{id}")
    public ResponseEntity<?> updatePermissionById(@PathVariable Integer id, @RequestBody Permission permission) {

        try {
            Permission update = permissionService.updatePermissionById(id, permission);
            return ResponseEntity.ok(update);
        } catch (Exception e) {
            if (e.getMessage().contains("no value present")) {
                return ResponseEntity.status(404).body(new Login404Response("user id :[" + id + "] Not found"));
            }
        }

        return null;
    }

}
