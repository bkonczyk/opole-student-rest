package pl.sda.spring.students.domain.student;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class StudentExceptionHandler {


    @ExceptionHandler(StudentNotFoundException.class)
    StudentError handleStudentError(StudentNotFoundException e) {
        return new StudentError(e.getMessage(), LocalDateTime.now());
    }
}
