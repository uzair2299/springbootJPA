package com.example.jpalearn.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long     id;

    private String name;

    private String email;

    private LocalDate birthday;

    @Override
    public String toString() {
        return String.format("Person [ id = %s, name = %s, email = %s createdAt = %s",id,name,email,birthday);
    }
}
