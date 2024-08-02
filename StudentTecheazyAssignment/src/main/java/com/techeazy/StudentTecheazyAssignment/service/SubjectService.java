package com.techeazy.StudentTecheazyAssignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techeazy.StudentTecheazyAssignment.dao.SubjectDao;
import com.techeazy.StudentTecheazyAssignment.dto.Subject;

@Service
public class SubjectService {
	private SubjectDao subjectDao;

	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

}
