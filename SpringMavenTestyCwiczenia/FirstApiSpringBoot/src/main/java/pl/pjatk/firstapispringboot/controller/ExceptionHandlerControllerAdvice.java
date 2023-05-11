package pl.pjatk.firstapispringboot.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        String errorMessage = "Exception occurred on request. Exception message: " + ex.getMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
