package com.example.jpalearn.Entity;

import com.example.jpalearn.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String rollNumber;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "Student_courses",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", status=" + status +
                ", passport=" + passport +
                '}';
    }
}
