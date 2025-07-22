package com.example.jpalearn.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int rating;



    @ManyToOne
    private Course course;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }

}
