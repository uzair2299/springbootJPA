package com.example.jpalearn.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
               // ", reviews=" + reviews + //// ❌ Lazy loading triggered here!
                '}';
    }
}
