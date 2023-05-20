package com.finalEcommers.demo.exception;

public class ResourceNotFoundExceptin extends RuntimeException{
    public ResourceNotFoundExceptin() {
        super();
    }

    public ResourceNotFoundExceptin(String message) {
        super(message);
    }
}
