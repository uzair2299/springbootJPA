package com.example.jpalearn;

import com.example.jpalearn.Entity.Task;
import com.example.jpalearn.repository.TaskRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

        //    @Test
        //    @Disabled
        //    void testDeleteById(){
        //        Task task = new Task();
        //        task.setCompleted(true);
        //        task.setTitle("testing");
        //        task.setDescription("testing");
        //
        //        Task savedTask =  taskRepository.insert(task);
        //        taskRepository.deleteById(savedTask.getId());
        //
        //        Task deleteTask = taskRepository.findById(savedTask.getId());
        //        //assertNull(deleteTask);
        //    }
}
