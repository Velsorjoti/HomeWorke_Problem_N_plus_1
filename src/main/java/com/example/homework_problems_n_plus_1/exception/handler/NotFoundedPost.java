package com.example.homework_problems_n_plus_1.exception.handler;

import com.example.homework_problems_n_plus_1.exception.NotFoundedPostException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundedPost {

    @ExceptionHandler(NotFoundedPostException.class)
    public ResponseEntity<?>notFound(){
        return ResponseEntity.notFound().build();
    }
}
//