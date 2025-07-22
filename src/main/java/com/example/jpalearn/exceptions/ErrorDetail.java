package com.example.jpalearn.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorDetail {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private int status;
}
