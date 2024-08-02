package com.techeazy.StudentTecheazyAssignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techeazy.StudentTecheazyAssignment.dto.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
