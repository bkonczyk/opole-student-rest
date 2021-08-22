package pl.sda.spring.students.domain.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.students.domain.course.Course;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class StudentView {
    private Long id;
    private String name;
    private String lastName;
    private Sex sex;
    private Set<Course> courses;
}
