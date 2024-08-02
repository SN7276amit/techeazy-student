package com.techeazy.StudentTecheazyAssignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techeazy.StudentTecheazyAssignment.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
