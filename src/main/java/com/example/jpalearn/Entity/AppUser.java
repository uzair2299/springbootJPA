package com.example.jpalearn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "AppUser")
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return String.format("Person [ id = %s, name = %s, email = %s createdAt = %s",id,name,email,createdAt);
    }
}
