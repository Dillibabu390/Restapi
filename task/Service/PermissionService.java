package com.api.task.Service;

import antlr.ASTNULLType;
import com.api.task.entity.*;
import com.api.task.repo.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {


    @Autowired
    PermissionRepo permissionRepo;


    //List
    public List<Permission> getPermission() {
        List<Permission> PermissionList = new ArrayList<>();
        permissionRepo.findAll().forEach(permission -> PermissionList.add(permission));
        return PermissionList;
    }

    //Get by id
    public Optional <Permission> getPermissionById(int id) {
        return permissionRepo.findById(id);
    }

    //create
    public Object postStudent(Permission permission) {
        try {
            permissionRepo.save(permission);
            return "save Successfully";
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return new ResponseErrorCreate("Already Exist");
            } else {
              //  return new ResponseErrorCreate("mention id");
                return  new ResponseErrorCreate(e.getMessage());
            }
        }
    }


    public ResponseEntity<Object> PermissiondeleteById(Integer id) {
        try {
              permissionRepo.deleteById(id);
            return ResponseEntity.status(200).body(new Delete200Response("User [" + id + "] deleted"));
        } catch (Exception e) {
            if (e.getMessage().contains("No class com.example.Organization.entity.user entity with id")) {
                return ResponseEntity.status(404).body(new Delete200Response("User [" + id + "] not found"));
            }
            return null;
        }
    }

// update by id
    public Permission updatePermissionById(Integer id, Permission permission) {
        Permission findById = permissionRepo.findById(id).get();
        findById.setCode(permission.getCode());
        findById.setDescription(permission.getDescription());
        try {
            permissionRepo.save(findById);
        } catch (IllegalStateException e) {
            e.getLocalizedMessage();
        }
        return findById;
    }

}
