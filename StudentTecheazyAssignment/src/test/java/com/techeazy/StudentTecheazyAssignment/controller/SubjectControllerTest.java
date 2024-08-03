package com.techeazy.StudentTecheazyAssignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techeazy.StudentTecheazyAssignment.dto.Subject;
import com.techeazy.StudentTecheazyAssignment.service.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SubjectService subjectService;

	@Autowired
	private ObjectMapper objectMapper;

	private Subject subject;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		subject = new Subject();
		subject.setId(1);
		subject.setName("Mathematics");
	}

	@Test
	void getAllSubjects() throws Exception {
		List<Subject> subjects = new ArrayList<>();
		subjects.add(subject);

		when(subjectService.getAllSubjects()).thenReturn(subjects);

		mockMvc.perform(get("/api/subjects").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1)).andExpect(jsonPath("$[0].name").value("Mathematics"));
	}
}
