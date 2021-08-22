package pl.sda.spring.students.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.spring.students.domain.course.Course;
import pl.sda.spring.students.domain.student.Sex;
import pl.sda.spring.students.domain.student.Student;
import pl.sda.spring.students.domain.student.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MockDataStudents {

    private final StudentRepository studentRepository;

    @PostConstruct
    void addSampleStudents() {
        studentRepository.save(new Student(
                null,
                "Andrzej",
                "Gołota",
                Sex.M,
                new ArrayList<Course>()));
        studentRepository.save(new Student(
                null,
                "Adam",
                "Małysz",
                Sex.M,
                new ArrayList<Course>()
        ));

    }
}
