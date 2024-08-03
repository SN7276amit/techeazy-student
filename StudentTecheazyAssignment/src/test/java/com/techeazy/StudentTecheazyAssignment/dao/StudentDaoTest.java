package com.techeazy.StudentTecheazyAssignment.dao;

import com.techeazy.StudentTecheazyAssignment.dto.Student;
import com.techeazy.StudentTecheazyAssignment.repo.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@SpringJUnitConfig
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentRepo studentRepo;

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        studentRepo.deleteAll(); 

        student1 = new Student();
        student1.setName("John Doe");
        student1.setAddress("japan");

        student2 = new Student();
        student2.setName("Jane Smith");
        student2.setAddress("america");

        studentDao.saveStudent(student1);
        studentDao.saveStudent(student2);
    }

    @Test
    void saveStudent_ShouldSaveStudent() {
        Student student = new Student();
        student.setName("Michael Johnson");
        student.setAddress("usa");

        Student savedStudent = studentDao.saveStudent(student);

        assertNotNull(savedStudent.getId());
        assertEquals("Michael Johnson", savedStudent.getName());
        assertEquals("usa", savedStudent.getAddress());
    }

    @Test
    void getAllStudents_ShouldReturnListOfStudents() {
        List<Student> students = studentDao.getAllStudents();

        assertNotNull(students);
        assertEquals(2, students.size());
    }

    @Test
    void getAllStudents_ShouldReturnEmptyListWhenNoStudents() {
        studentRepo.deleteAll(); 

        List<Student> students = studentDao.getAllStudents();

        assertNotNull(students);
        assertTrue(students.isEmpty());
    }
}
