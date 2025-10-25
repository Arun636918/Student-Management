package com.example.studentmanagement.Studentmanagement.controller;

import com.example.studentmanagement.Studentmanagement.Entity.Student;
import com.example.studentmanagement.Studentmanagement.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.addStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{course}")
    public ResponseEntity<List<Student>> getByCourse(@PathVariable String course) {
        return ResponseEntity.ok(service.getByCourse(course));
    }

    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Student>> getByGrade(@PathVariable String grade) {
        return ResponseEntity.ok(service.getByGrade(grade));
    }
}

