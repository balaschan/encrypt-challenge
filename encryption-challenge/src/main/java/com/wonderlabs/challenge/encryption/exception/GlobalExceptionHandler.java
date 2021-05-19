package com.wonderlabs.challenge.encryption.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/***
 * Application level exception handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle Specific Exception
    @ExceptionHandler(com.wonderlabs.challenge.encryption.exception.EncryptionChallengeException.class)
    private ResponseEntity<?> handleEncryptionChallengeException(EncryptionChallengeException exception) {
        return new ResponseEntity("Error while processing a request", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
