package com.example.studentmanagement.Studentmanagement.repository;

import com.example.studentmanagement.Studentmanagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByCourse(String course);
    List<Student> findByGrade(String grade);
}
