package com.techeazy.StudentTecheazyAssignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techeazy.StudentTecheazyAssignment.dto.Student;
import com.techeazy.StudentTecheazyAssignment.service.StudentService;
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
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Autowired
	private ObjectMapper objectMapper;

	private Student student;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		student = new Student();
		student.setId(1);
		student.setName("John Doe");
		student.setAddress("spur");
		;
	}

	@Test
    void createStudent() throws Exception {
        when(studentService.saveStudent(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/api/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.address").value("spur"));
    }

	@Test
	void getAllStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		students.add(student);

		when(studentService.getAllStudents()).thenReturn(students);

		mockMvc.perform(get("/api/student").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1)).andExpect(jsonPath("$[0].name").value("John Doe"))
				.andExpect(jsonPath("$[0].address").value("spur"));
	}
}
