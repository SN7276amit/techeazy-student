package com.techeazy.StudentTecheazyAssignment.service;

import com.techeazy.StudentTecheazyAssignment.dao.StudentDao;
import com.techeazy.StudentTecheazyAssignment.dto.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentDao studentDao;

    private Student student;
    private List<Student> studentList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        student = new Student();
        student.setId(1);
        student.setName("John Doe");

        studentList = new ArrayList<>();
        studentList.add(student);
    }

    @Test
    void saveStudent() {
        when(studentDao.saveStudent(student)).thenReturn(student);

        Student result = studentService.saveStudent(student);

        assertNotNull(result);
        assertEquals(student.getName(), result.getName());
        verify(studentDao, times(1)).saveStudent(student);
    }

    @Test
    void getAllStudents() {
        when(studentDao.getAllStudents()).thenReturn(studentList);

        List<Student> result = studentService.getAllStudents();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(student.getName(), result.get(0).getName());
        verify(studentDao, times(1)).getAllStudents();
    }
}
