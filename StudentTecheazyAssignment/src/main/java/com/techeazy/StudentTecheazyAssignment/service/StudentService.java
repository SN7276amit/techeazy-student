package com.techeazy.StudentTecheazyAssignment.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techeazy.StudentTecheazyAssignment.dao.StudentDao;
import com.techeazy.StudentTecheazyAssignment.dto.Student;
@Service
public class StudentService {
    @Autowired
	private StudentDao studentDao;
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

}
