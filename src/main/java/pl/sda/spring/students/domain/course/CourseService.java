package pl.sda.spring.students.domain.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.spring.students.domain.student.Student;
import pl.sda.spring.students.domain.student.StudentService;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public void add(Course course) {
        courseRepository.save(course);
    }

    public void addToStudent(Course request, Long studentId) {
        Student student = studentService.getStudent(studentId);
        boolean courseAlreadyTaken = student.getCourses()
                .stream()
                .anyMatch(course -> course.getName().equals(request.getName()));

        if (courseAlreadyTaken) {
            throw new RuntimeException("Student with id: " + studentId + " has already taken the course");
        }
        student.getCourses().add(request);
        studentService.save(student);
    }
}
