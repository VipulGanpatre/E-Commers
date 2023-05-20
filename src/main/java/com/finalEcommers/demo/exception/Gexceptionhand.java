package com.finalEcommers.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Gexceptionhand {
    @ExceptionHandler(ResourceNotFoundExceptin.class)
    public String HandlerresourceNotfoundExeption(ResourceNotFoundExceptin rx){
        return rx.getMessage();
    }
}
