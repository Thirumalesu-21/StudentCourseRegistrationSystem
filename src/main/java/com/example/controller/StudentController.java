package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.example.service.StudentService;
import com.example.student.model.Student;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET: View all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // GET: Find student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // POST: Register a student
    @PostMapping
    public Student registerStudent(@Valid @RequestBody Student student) {
        return service.registerStudent(student);
    }

    // DELETE: Delete student registration
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
}