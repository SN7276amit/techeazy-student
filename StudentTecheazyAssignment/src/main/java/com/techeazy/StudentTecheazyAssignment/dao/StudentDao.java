package com.techeazy.StudentTecheazyAssignment.dao;

import java.util.List;

import com.techeazy.StudentTecheazyAssignment.dto.Student;
import com.techeazy.StudentTecheazyAssignment.repo.StudentRepo;

public class StudentDao {

	private StudentRepo studentRepo;

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

}
