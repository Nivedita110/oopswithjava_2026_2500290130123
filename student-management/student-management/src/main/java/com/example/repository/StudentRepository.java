package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
