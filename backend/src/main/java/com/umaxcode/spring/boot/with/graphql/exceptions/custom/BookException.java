package com.umaxcode.spring.boot.with.graphql.exceptions.custom;

import org.springframework.http.HttpStatus;


public class BookException extends CustomException {

    public BookException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
