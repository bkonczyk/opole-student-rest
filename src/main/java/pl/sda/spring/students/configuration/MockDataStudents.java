package pl.sda.spring.students.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.spring.students.domain.course.Course;
import pl.sda.spring.students.domain.student.Sex;
import pl.sda.spring.students.domain.student.Student;
import pl.sda.spring.students.domain.student.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class MockDataStudents {

    private final StudentRepository studentRepository;

    @PostConstruct
    void addSampleStudents() {
        studentRepository.save(new Student(
                null,
                "Andrzej",
                "Gołota",
                Sex.M,
                Set.of(new Course(null, "Boks"))));

        studentRepository.save(new Student(
                null,
                "Adam",
                "Małysz",
                Sex.M,
                Set.of(new Course(null, "Skoki"))
        ));
    }
}
