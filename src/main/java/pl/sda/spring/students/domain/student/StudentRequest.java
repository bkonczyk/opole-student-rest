package pl.sda.spring.students.domain.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private String lastName;
    private Sex sex;



}
