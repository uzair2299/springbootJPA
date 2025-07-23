package com.example.jpalearn.repository;

import com.example.jpalearn.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public interface   UserJPARepository extends JpaRepository<User,Long> {

}
