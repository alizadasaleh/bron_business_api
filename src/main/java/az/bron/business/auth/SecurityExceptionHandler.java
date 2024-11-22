package az.bron.business.auth;

import az.gov.dlp.exception.model.ErrorDetails;
import az.gov.dlp.exception.model.ResponseProblemDetail;
import io.jsonwebtoken.ExpiredJwtException;
import java.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(-1)
@RestControllerAdvice
public class SecurityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(SecurityExceptionHandler.class);

    public SecurityExceptionHandler() {
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseProblemDetail handleBadCredentials(BadCredentialsException ex) {
        log.error("Bad credentials error: {}", ex.getMessage());
        return createResponseProblemDetail(HttpStatus.UNAUTHORIZED, "Bad login credentials", 401_00, "BadCredentials");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccountStatusException.class)
    public ResponseProblemDetail handleAccountStatusException(AccountStatusException ex) {
        log.error("Account locked error: {}", ex.getMessage());
        return createResponseProblemDetail(HttpStatus.FORBIDDEN, "Account locked", 403_00, "AccountLocked");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseProblemDetail handleAccessDeniedException(AccessDeniedException ex) {
        log.error("Access denied error: {}", ex.getMessage());
        return createResponseProblemDetail(HttpStatus.FORBIDDEN, "Not authorized to access this resource", 403_01,
                "AccessDenied");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(SignatureException.class)
    public ResponseProblemDetail handleInvalidJWT(SignatureException ex) {
        log.error("Invalid JWT error: {}", ex.getMessage());
        return createResponseProblemDetail(HttpStatus.UNAUTHORIZED, "Invalid JWT", 401_01, "InvalidJWT");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseProblemDetail handleExpiredJWT(ExpiredJwtException ex) {
        log.error("JWT expired error: {}", ex.getMessage());
        return createResponseProblemDetail(HttpStatus.UNAUTHORIZED, "JWT has expired", 401_02, "ExpiredJWT");
    }

    private ResponseProblemDetail createResponseProblemDetail(HttpStatus status, String detail, int errorCode,
                                                              String errorName) {
        ErrorDetails errorDetails = ErrorDetails.of("", detail, "", ErrorDetails.error(errorCode, errorName));
        return ResponseProblemDetail.of(status, errorDetails);
    }
}
