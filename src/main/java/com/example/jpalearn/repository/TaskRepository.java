package com.example.jpalearn.repository;

import com.example.jpalearn.Entity.AppUser;
import com.example.jpalearn.Entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TaskRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    //The commit happens after the method returns — at the end of the transaction.
    public Task findById(int id) throws InterruptedException {
        logger.info("going to get data with entity manager with id {}", id);
        Task task = entityManager.find(Task.class, id);
        task.setTitle("hello");
        Thread.sleep(5000);
        logger.info("going to return data with entity manager");
        return task;
    }

    public Task insert(Task task) {
        return entityManager.merge(task);
    }

    public void deleteById(int id) throws InterruptedException {
        Task task = findById(id);
        entityManager.remove(task);
    }

    public List<Task> findAllNative() {
        return entityManager.createNamedQuery("query_find_all",Task.class).getResultList();
    }

    public Task findByIdNative(int id) {
        return entityManager.createNamedQuery("query_find_by_id",Task.class).setParameter(1,id).getSingleResult();
    }

}
