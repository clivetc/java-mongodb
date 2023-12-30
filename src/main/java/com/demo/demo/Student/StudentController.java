package com.demo.demo.Student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    };

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudentById(@PathVariable("studentId") String studentId){
        studentService.deleteStudentById(studentId);
    }

    @PostMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") String studentId,
                            @RequestParam(required = false) String firstName,
                            @RequestParam(required = false) String lastName,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) Address address,
                            @RequestParam(required = false) List<String> favoriteSubjects,
                            @RequestParam(required = false) BigDecimal totalSpentInBooks){
        studentService.updateStudent(studentId,firstName,lastName,email,address,favoriteSubjects,totalSpentInBooks);
    }
}
