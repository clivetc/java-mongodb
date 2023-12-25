package com.demo.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private  final StudentRepository studentRepository;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email Already in Use");
        }

        studentRepository.insert(student);
    }

    public void deleteStudentById(String studentId){
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Student with id"+ studentId +"does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(String studentId, String firstName, String lastName, String email, Address address, List<String> favoriteSubjects, BigDecimal totalSpentInBooks) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));

        if (firstName != null && !firstName.isEmpty() && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }

        if (lastName != null && !lastName.isEmpty() && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }

        if (address != null && !Objects.equals(student.getAddress(), address)) {
            student.setAddress(address);
        }

        if (favoriteSubjects != null && !favoriteSubjects.isEmpty()) {
            student.setFavoriteSubjects(favoriteSubjects);
        }
        if(totalSpentInBooks != null){
            student.setTotalSpentInBooks(totalSpentInBooks);
        }

    }

}
