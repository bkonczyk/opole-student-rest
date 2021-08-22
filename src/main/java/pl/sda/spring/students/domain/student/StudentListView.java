package pl.sda.spring.students.domain.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.students.domain.course.Course;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class StudentListView {
    private Long id;
    private String name;
    private String lastName;
    private Sex sex;
    private List<Course> courses;
}
