package com.example.jpalearn.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Setter
@Getter
//@NamedNativeQuery(name = "query_find_all", query = "Select * from tasks")
@NamedNativeQueries({
        @NamedNativeQuery(name = "query_find_all",query = "Select * from tasks",resultClass = Task.class),
        @NamedNativeQuery(name = "query_find_by_id",query = "Select * from tasks where id = ?",resultClass = Task.class)
})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "is_completed")
    private boolean completed;

    @Column(name = "due_date")
    private String dueDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

}
