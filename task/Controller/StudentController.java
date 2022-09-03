package com.api.task.Controller;

import com.api.task.Service.StudentService;
import com.api.task.entity.Create403Response;
import com.api.task.entity.Student;
import com.api.task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class StudentController {

    @Autowired
    private StudentService Studentservice;




    @GetMapping(value = "/student/list")
    public List<Student> getStudent() {
        return Studentservice.getStudent();
    }


    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable("id") int id) {
        Optional<Student> user = (Studentservice.getStudentById(id));
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(404).body(new Create403Response("user[" + id + "] not found"));
        }
    }

    @PostMapping(value = "/student/create")
    public ResponseEntity<Object> postStudent(@RequestBody Student student) {
        Object create = Studentservice.postStudent(student);
        return ResponseEntity.status(201).body(create);
    }



    @PutMapping(value = "/student/update")
    public Object updateStudent(@RequestBody Student student) {
        return Studentservice.updateStudent(student);
    }


    @DeleteMapping(value = "/student/delete/{id}")
    public ResponseEntity<Object> StudentdeleteById(@PathVariable Integer id) {
        return Studentservice.StudentdeleteById(id);
    }




}
