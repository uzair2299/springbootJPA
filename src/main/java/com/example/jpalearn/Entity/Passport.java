package com.example.jpalearn.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
