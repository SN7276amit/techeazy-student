package com.techeazy.StudentTecheazyAssignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techeazy.StudentTecheazyAssignment.dto.Subject;
import com.techeazy.StudentTecheazyAssignment.repo.SubjectRepo;
@Repository
public class SubjectDao {
   @Autowired
	private SubjectRepo subjectRepo;

	public List<Subject> getAllSubjects() {
		return subjectRepo.findAll();
	}

}
