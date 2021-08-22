package pl.sda.spring.students.domain.student;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentError {

    private String msg;
    private LocalDateTime timestamp;
}
