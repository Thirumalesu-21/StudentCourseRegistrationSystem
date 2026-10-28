package com.example.service;

import com.example.student.model.Student;
import com.example.Exception.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Register student
    public Student registerStudent(Student student) {
        student.setStudentId(idGenerator.getAndIncrement());
        students.add(student);
        return student;
    }

    // View all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Find student by ID
    public Student getStudentById(Long id) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                    new StudentNotFoundException(
                        "Student not found with ID: " + id));
    }

    // Delete registration
    public String deleteStudent(Long id) {
        Student student = getStudentById(id);
        students.remove(student);

        return "Student registration deleted successfully. ID: " + id;
    }
}