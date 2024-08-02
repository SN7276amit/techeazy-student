package com.techeazy.StudentTecheazyAssignment.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.StudentTecheazyAssignment.dto.Student;
import com.techeazy.StudentTecheazyAssignment.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

}

