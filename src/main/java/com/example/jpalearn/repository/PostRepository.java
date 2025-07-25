package com.example.jpalearn.repository;

import com.example.jpalearn.Entity.Post;
import com.example.jpalearn.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
