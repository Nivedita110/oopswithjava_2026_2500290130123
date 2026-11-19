
package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.StudentEntity;
import com.example.repository.StudentRepository;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add Student
    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By ID
    public Optional<StudentEntity> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // Update Student
    public StudentEntity updateStudent(int id, StudentEntity student) {
        student.setStudentId(id);
        return studentRepository.save(student);
    }

    // Delete Student
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
// Display Merit List
public List<StudentEntity> getMeritList() {
    List<StudentEntity> students = studentRepository.findAll();

    students.sort((s1, s2) -> {
        double avg1 = (s1.getProgrammingScore() + s1.getMathematicsScore()) / 2;
        double avg2 = (s2.getProgrammingScore() + s2.getMathematicsScore()) / 2;

        return Double.compare(avg2, avg1);
    });

    return students;
}
}

