package pl.sda.spring.students.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static pl.sda.spring.students.domain.student.StudentMapper.*;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public void addStudent(StudentRequest request) {
        Student student = mapRequestToStudent(request);
        save(student);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Page<StudentListView> getPageOfStudents(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Student> studentsPage = repository.findAll(pageRequest);
        return studentsPage.map(student -> mapToStudentListView(student));
    }

    public StudentView getStudentView(Long id) {
        Student student = getStudent(id);
        StudentView studentView = mapToStudentView(student);
        return studentView;
    }

    public Student getStudent(Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }
}
