package com.example.studentmanagement.Studentmanagement.service;

import com.example.studentmanagement.Studentmanagement.Entity.Student;
import com.example.studentmanagement.Studentmanagement.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	@Autowired
	private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repo.findById(id);
    }

    public Student updateStudent(Long id, Student updated) {
        return repo.findById(id)
                .map(student -> {
                    student.setName(updated.getName());
                    student.setCourse(updated.getCourse());
                    student.setGrade(updated.getGrade());
                    student.setAge(updated.getAge());
                    return repo.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public List<Student> getByCourse(String course) {
        return repo.findByCourse(course);
    }

    public List<Student> getByGrade(String grade) {
        return repo.findByGrade(grade);
    }
}
