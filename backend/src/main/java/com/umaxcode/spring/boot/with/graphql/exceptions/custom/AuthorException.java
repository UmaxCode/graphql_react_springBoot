package com.umaxcode.spring.boot.with.graphql.exceptions.custom;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthorException extends CustomException {
    public AuthorException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
