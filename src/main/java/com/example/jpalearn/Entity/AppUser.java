package com.example.jpalearn.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AppUser {
    private int id;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return String.format("Person [ id = %s, name = %s, email = %s createdAt = %s",id,name,email,createdAt);
    }
}
