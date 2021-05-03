package com.app.cachedemo.controller;

import com.app.cachedemo.model.Student;
import com.app.cachedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.addNewStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/student")
    public ResponseEntity<?> retriveAllStudents() {
        return new ResponseEntity<>(service.findAllStudents(), HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.OK);
    }

}
