package com.techeazy.StudentTecheazyAssignment.dao;

import java.util.List;

import com.techeazy.StudentTecheazyAssignment.dto.Subject;
import com.techeazy.StudentTecheazyAssignment.repo.SubjectRepo;

public class SubjectDao {

	private SubjectRepo subjectRepo;

	public List<Subject> getAllSubjects() {
		return subjectRepo.findAll();
	}

}
