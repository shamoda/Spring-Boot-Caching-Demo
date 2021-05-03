package com.app.cachedemo.service;

import com.app.cachedemo.model.Student;
import com.app.cachedemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addNewStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public String deleteStudent(Long id) {
        repository.deleteById(id);
        return "record deleted successfully";
    }

}
