package com.techeazy.StudentTecheazyAssignment.service;

import com.techeazy.StudentTecheazyAssignment.dao.SubjectDao;
import com.techeazy.StudentTecheazyAssignment.dto.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SubjectServiceTest {

	@InjectMocks
	private SubjectService subjectService;

	@Mock
	private SubjectDao subjectDao;

	private List<Subject> subjectList;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		Subject subject1 = new Subject();
		subject1.setId(1);
		subject1.setName("Mathematics");

		Subject subject2 = new Subject();
		subject2.setId(2);
		subject2.setName("Science");

		subjectList = Arrays.asList(subject1, subject2);
	}

	@Test
    void getAllSubjects_ReturnsSubjectList() {
        when(subjectDao.getAllSubjects()).thenReturn(subjectList);

        List<Subject> subjects = subjectService.getAllSubjects();

        assertNotNull(subjects);
        assertEquals(2, subjects.size());
        assertEquals("Mathematics", subjects.get(0).getName());
        assertEquals("Science", subjects.get(1).getName());
    }

	@Test
    void getAllSubjects_NoSubjects() {
        when(subjectDao.getAllSubjects()).thenReturn(Arrays.asList());

        List<Subject> subjects = subjectService.getAllSubjects();

        assertNotNull(subjects);
        assertTrue(subjects.isEmpty());
    }
}
