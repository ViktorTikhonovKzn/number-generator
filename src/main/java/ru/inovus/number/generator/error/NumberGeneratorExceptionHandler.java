package ru.inovus.number.generator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Перехватчик внутренних исключений приложения
 */
@ControllerAdvice
public class NumberGeneratorExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Перехватывает NumbersIsOverException и возвращает статус 404
     *
     * @param response
     * @throws IOException
     */
    @ExceptionHandler(NumbersIsOverException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

}
