package com.demo.demo.repository;

import com.demo.demo.Student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String>{
    Optional<Student> findStudentByEmail(String email);
}
