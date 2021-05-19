package com.wonderlabs.challenge.encryption.exception;

/**
 * Custom Exception for application level
 */
public class EncryptionChallengeException extends RuntimeException {

    private static final long serialVersionUID = 7718828512143293558L;

    public EncryptionChallengeException(Throwable cause) {
        super(cause);
    }

    public EncryptionChallengeException(String message, Throwable cause) {
        super(message, cause);

    }

}
