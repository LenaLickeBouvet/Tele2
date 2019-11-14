package se.comhem.test.montyhall.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArg(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
