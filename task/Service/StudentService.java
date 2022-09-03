package com.api.task.Service;

import antlr.ASTNULLType;
import com.api.task.entity.Delete200Response;
import com.api.task.entity.ResponseErrorCreate;
import com.api.task.entity.Student;
import com.api.task.entity.User;
import com.api.task.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getStudent() {
        List<Student> StudentList = new ArrayList<>();
        studentRepo.findAll().forEach(student -> StudentList.add(student));
        return StudentList;
    }




    public Object postStudent(Student student) {
        try {
            studentRepo.save(student);
            return "save Successfully";
        } catch (Exception e) {
            if (e.getMessage().contains("ConstraintViolationException")) {
                return new ResponseErrorCreate("Already Exist");
            } else {
                return new ResponseErrorCreate("mention id");
            }
        }
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }



    public Object updateStudent(Student student) {
        return studentRepo.save(student);
    }



    public ResponseEntity<Object> StudentdeleteById(Integer id) {
        try {
            studentRepo.deleteById(id);
            return ResponseEntity.status(200).body(new Delete200Response("User [" + id + "] deleted"));
        } catch (Exception e) {
            if (e.getMessage().contains("No class com.example.Organization.entity.user entity with id")) {
                return ResponseEntity.status(404).body(new Delete200Response("User [" + id + "] not found"));
            }
            return null;
        }
    }

}
