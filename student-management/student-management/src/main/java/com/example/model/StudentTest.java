package com.example.model;

import java.util.Arrays;

public class StudentTest {

    public static void main(String[] args) {

        Student s1 = new Student(
            101,
            "Rahul",
            "rahul@gmail.com",
            "Java",
            90,
            80,
            Arrays.asList("Java", "Spring Boot", "MySQL")
        );

        System.out.println("Student ID: " + s1.getStudentId());
        System.out.println("Name: " + s1.getStudentName());
        System.out.println("Email: " + s1.getEmail());
        System.out.println("Course: " + s1.getCourseName());
        System.out.println("Programming Score: " + s1.getProgrammingScore());
        System.out.println("Maths Score: " + s1.getMathematicsScore());
        System.out.println("Skills: " + s1.getTechnicalSkills());
        System.out.println("Average: " + s1.getAverageScore());
        System.out.println("Category: " + s1.getPerformanceCategory());
        System.out.println("Stronger Subject: " + s1.getStrongerSubject());
    }
}