package com.techeazy.StudentTecheazyAssignment.dao;

import com.techeazy.StudentTecheazyAssignment.dto.Subject;
import com.techeazy.StudentTecheazyAssignment.repo.SubjectRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@SpringJUnitConfig
public class SubjectDaoTest {

	@Autowired
	private SubjectDao subjectDao;

	@Autowired
	private SubjectRepo subjectRepo;

	private Subject subject1;
	private Subject subject2;

	@BeforeEach
	void setUp() {
		subjectRepo.deleteAll(); 

		subject1 = new Subject();
		subject1.setName("Mathematics");

		subject2 = new Subject();
		subject2.setName("Science");

		subjectDao.getAllSubjects().add(subject1);
		subjectDao.getAllSubjects().add(subject2);
	}

	@Test
	void getAllSubjects_ShouldReturnListOfSubjects() {
		List<Subject> subjects = subjectDao.getAllSubjects();

		assertNotNull(subjects);
		assertEquals(2, subjects.size());
		assertTrue(subjects.contains(subject1));
		assertTrue(subjects.contains(subject2));
	}

	@Test
	void getAllSubjects_ShouldReturnEmptyListWhenNoSubjects() {
		subjectRepo.deleteAll();

		List<Subject> subjects = subjectDao.getAllSubjects();

		assertNotNull(subjects);
		assertTrue(subjects.isEmpty());
	}
}
