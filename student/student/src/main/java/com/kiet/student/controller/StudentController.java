
package com.kiet.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.student.model.Student;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(101, "Rahul Sharma",
                "rahul@kiet.edu", "CSE", 2, 8.65));
        students.add(new Student(102, "Priya Singh",
                "priya@kiet.edu", "CSE", 2, 9.20));
        students.add(new Student(103, "Aman Verma",
                "aman@kiet.edu", "ECE", 3, 8.10));
        students.add(new Student(104, "Neha Gupta",
                "neha@kiet.edu", "CSE", 3, 9.50));
        students.add(new Student(105, "Rohan Kumar",
                "rohan@kiet.edu", "IT", 2, 7.90));
    }

    // 1. Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    // 2. Get student by ID
    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> getStudentById(
            @PathVariable int studentId) {

        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                return ResponseEntity.ok(s);
            }
        }

        return ResponseEntity.status(404)
                .body(Map.of("message", "Student not found"));
    }

    // 3. Add a new student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // 4. Update student details
    @PutMapping("/students/{studentId}")
    public ResponseEntity<?> updateStudent(
            @PathVariable int studentId,
            @RequestBody Student updatedStudent) {

        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                s.setBranch(updatedStudent.getBranch());
                s.setYear(updatedStudent.getYear());
                s.setCgpa(updatedStudent.getCgpa());

                return ResponseEntity.ok(s);
            }
        }

        return ResponseEntity.status(404)
                .body(Map.of("message", "Student not found"));
    }

    // 5. Delete student
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable int studentId) {

        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                students.remove(s);
                return ResponseEntity.ok(
                        Map.of("message",
                               "Student deleted successfully"));
            }
        }

        return ResponseEntity.status(404)
                .body(Map.of("message", "Student not found"));
    }

    // 6. Search students by branch and year
    @GetMapping("/students/search")
    public List<Student> searchStudents(
            @RequestParam String branch,
            @RequestParam int year) {

        return students.stream()
                .filter(s -> s.getBranch().equalsIgnoreCase(branch)
                        && s.getYear() == year)
                .collect(Collectors.toList());
    }

    // 7. Find students with CGPA >= given value
    @GetMapping("/students/topper")
    public List<Student> getToppers(@RequestParam double cgpa) {

        return students.stream()
                .filter(s -> s.getCgpa() >= cgpa)
                .collect(Collectors.toList());
    }
}

