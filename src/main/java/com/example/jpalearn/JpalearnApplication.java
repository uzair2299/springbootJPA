package com.example.jpalearn;

import com.example.jpalearn.DataAccess.AppUserRepo;
import com.example.jpalearn.Entity.*;
import com.example.jpalearn.enums.Status;
import com.example.jpalearn.repository.CourseRepository;
import com.example.jpalearn.repository.ReviewRepository;
import com.example.jpalearn.repository.StudentRepository;
import com.example.jpalearn.repository.TaskRepository;
import com.example.jpalearn.rowMapper.AppUserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpalearnApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private AppUserRepo appUserRepo;

    @Autowired
    private AppUserRowMapper appUserRowMapper;


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    public static Student getStudent() {
        Student student = new Student();
        student.setEmail("student@gmail.com");
        student.setName("student");
        student.setRollNumber("123456");
        student.setStatus(Status.ACTIVE);
        return student;
    }

    private Passport getPassport() {
        Passport passport = new Passport();
        passport.setNumber("Pass-123");
        return passport;
    }

    private Course getCourse() {
        Course course = new Course();
        course.setTitle("Testing Course");
        return course;
    }

    private Review getReview() {
        Review review = new Review();
        review.setDescription("Testing Review");
        review.setRating(3);
        return review;
    }

    private AppUser getAppUser(String email,String name){
        AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setName(name);
        return  appUser;
    }


    private void runJdbcTemplateOps(){
        AppUser appUser  = getAppUser("testing@gmail.com","testing");
        AppUser appUserUpdate  = getAppUser("Update_testing@gmail.com","Update_testing");
        AppUser nameParameterUser  = getAppUser("NamedParameter@gmail.com","NamedParameter");

        appUserUpdate.setId(2);

//        logger.info("Find all user - {}", appUserRepo.findAll().toString());
//        logger.info("Find by id user - {} ",appUserRepo.findById(1).toString());
//        logger.info("Delete by id User - {}",String.valueOf(appUserRepo.deleteById(1)));
//        logger.info("Save new user - {}",String.valueOf(appUserRepo.insert(appUser)));
//        logger.info("update the existing user - {}",String.valueOf(appUserRepo.update(appUserUpdate)));
//        logger.info("Response by using row mapper - {}", appUserRepo.findAll());

//        logger.info("---------------------------NamedParameterJdbcTemplate Start------------------------");
//        logger.info("NamedParameterJdbcTemplate Find by Id - {}" , String.valueOf(appUserRepo.findById_(3)));
//        logger.info("NamedParameterJdbcTemplate save  = {}", String.valueOf(appUserRepo.insert_(nameParameterUser)));
//        logger.info("---------------------------NamedParameterJdbcTemplate End------------------------");
    }
    
    private void runJpaEntityOps() throws InterruptedException {
        logger.info("---------------------------JPA Start------------------------");
        logger.info("Find by Id - {}", String.valueOf(taskRepository.findById(3)));
        logger.info("Find by Id by using native Query- {}", String.valueOf(taskRepository.findByIdNative(3)));
        taskRepository.findAllNative();
        Task task = new Task();
        task.setTitle("Testing");
        task.setDescription("Testing");
        task.setCompleted(true);
        logger.info("Insert Task - {}", String.valueOf(taskRepository.insert(task)));

        //taskRepository.deleteById();

        logger.info("---------------------------JPA End------------------------");
    }

    private void runJpaOneToOneOps() throws InterruptedException {
        logger.info("---------------------------JPA Relationship one to one start------------------------");
        Student student=  getStudent();
        Passport passport = getPassport();
        student.setPassport(passport);

        logger.info("1to1 - Saved Student data - {}", studentRepository.saveStudentWithPassport(student));
        logger.info("Find by Id Student data - {}", String.valueOf(studentRepository.findById(3L)));
        student.setId(6L);
        student.setName("student - update");
        logger.info("Update Student data - {}", String.valueOf(studentRepository.update(student)));
        studentRepository.deleteById(5L);
        logger.info("---------------------------JPA Relationship one to one end------------------------");

    }

    private void runJpaOneToManyOps() throws InterruptedException {
        logger.info("---------------------------JPA Relationship one to many start------------------------");
        Course c = courseRepository.save(getCourse());
        logger.info("Saved Student data - {}", c.toString());
        Course course = courseRepository.findById(3L);
        logger.info("Find by Id Course data - {}", String.valueOf(course));
        course.getReviews();
        Review review =  reviewRepository.addReviewToCourse(getReview(), 1L);
        Review r = reviewRepository.findById(review.getId());
        logger.info("Find by Id review data - {}", String.valueOf(r));
        logger.info("Delete Student data by Id");
        logger.info("---------------------------JPA Relationship one to Many end------------------------");

    }
    public static void main(String[] args) {
        SpringApplication.run(JpalearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //runJdbcTemplateOps();
        //runJpaEntityOps();
        //runJpaOneToOneOps();
        //runJpaOneToManyOps()

    }


}
