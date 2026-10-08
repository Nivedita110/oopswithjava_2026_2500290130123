package com.example.student_management;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(StudentManagementApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("KIET Student Management System Started");
        logger.info("Loading Student Data...");
        logger.info("Student Management REST API is Ready");
    }
}