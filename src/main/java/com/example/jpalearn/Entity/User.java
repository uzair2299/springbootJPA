package com.example.jpalearn.Entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
//@JsonIgnoreProperties({"name","email"})
@JsonFilter("userFilter")
public class User {
    private Long     id;

    @NotBlank(message = "Name is required")
    private String name;

    //@JsonIgnore
    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;

    @Past
    private LocalDate birthday;

    @Override
    public String toString() {
        return String.format("Person [ id = %s, name = %s, email = %s createdAt = %s",id,name,email,birthday);
    }
}
