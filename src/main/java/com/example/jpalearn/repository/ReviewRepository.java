package com.example.jpalearn.repository;

import com.example.jpalearn.Entity.Course;
import com.example.jpalearn.Entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ReviewRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;


    public Review addReviewToCourse(Review review, Long id) throws InterruptedException {
        logger.info("going to get data with entity manager with id {}", id);
        Course course = entityManager.find(Course.class, id);
        review.setCourse(course);
        review = entityManager.merge(review);
        logger.info("going to return data with entity manager");
        return review;
    }

    public Review findById(Long id){
        return entityManager.find(Review.class,id);
    }

//    public Student update(Student student) throws InterruptedException {
//       Student s =  findById(student.getId());
//       s.setName(student.getName());
//        return entityManager.merge(s);
//    }

    public Course save(Course course) {
        return entityManager.merge(course);
    }
//
//    public void deleteById(Long id) throws InterruptedException {
//        Student student = findById(id);
//        entityManager.remove(student);
//    }
//
//    public List<Task> findAllNative() {
//        return entityManager.createNamedQuery("query_find_all",Task.class).getResultList();
//    }
//
//    public Task findByIdNative(int id) {
//        return entityManager.createNamedQuery("query_find_by_id",Task.class).setParameter(1,id).getSingleResult();
//    }

}
