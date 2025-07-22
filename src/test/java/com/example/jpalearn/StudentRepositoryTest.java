package com.example.jpalearn;

import com.example.jpalearn.Entity.Student;
import com.example.jpalearn.repository.StudentRepository;
import com.example.jpalearn.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //// 👈 Enables non-static @BeforeAll
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;


    private Long studentId;

    @Test
    @Transactional
    @DirtiesContext
    void testFindById_returnsStudent() throws InterruptedException {

        Student student = new Student();
        student.setName("Test Student");
        student.setEmail("test@student.com");
        student.setRollNumber("R001");

        entityManager.persist(student);
        entityManager.flush();

        studentId = student.getId(); //

        Student found = studentRepository.findById(studentId);
        Assertions.assertNotNull(found);
        Assertions.assertEquals("Test Student", found.getName());
        Assertions.assertEquals("test@student.com", found.getEmail());
    }
}
