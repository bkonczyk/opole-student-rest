package pl.sda.spring.students.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public void addStudent(StudentRequest request) {
        Student student = mapRequestToStudent(request);
        repository.save(student);
    }

    private Student mapRequestToStudent(StudentRequest request) {
        return Student.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .sex(request.getSex())
                .build();
    }

    public Page<StudentListView> getPageOfStudents(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Student> studentsPage = repository.findAll(pageRequest);
        return studentsPage.map(student -> mapToStudentListView(student));
    }

    private StudentListView mapToStudentListView(Student student) {
        return StudentListView.of(
                student.getId(),
                student.getName(),
                student.getLastName(),
                student.getSex(),
                student.getCourses());
    }
}
