package knu.likelion12.BE_Session.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GlobalException extends ResponseStatusException {
    public GlobalException(HttpStatus status, String reason) {
        super(status, reason);
    }
}