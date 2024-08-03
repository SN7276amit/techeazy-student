package com.techeazy.StudentTecheazyAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.StudentTecheazyAssignment.dto.Subject;
import com.techeazy.StudentTecheazyAssignment.service.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
	private SubjectService subjectService;

	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjects = subjectService.getAllSubjects();
		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}
}
