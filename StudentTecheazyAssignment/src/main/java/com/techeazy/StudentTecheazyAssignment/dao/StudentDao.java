package com.techeazy.StudentTecheazyAssignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techeazy.StudentTecheazyAssignment.dto.Student;
import com.techeazy.StudentTecheazyAssignment.repo.StudentRepo;
@Repository
public class StudentDao {
    @Autowired
	private StudentRepo studentRepo;

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

}
