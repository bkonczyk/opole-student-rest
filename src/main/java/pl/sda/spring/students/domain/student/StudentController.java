package pl.sda.spring.students.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService service;

    @PostMapping
    void createStudent(@Valid @RequestBody StudentRequest student) {
        service.addStudent(student);
    }

    // http://localhost:8080/api/students?page=1&size=50
    @GetMapping
    Page<StudentListView> getAllStudents(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
        return service.getPageOfStudents(page, size);
    }

    @GetMapping("/{id}")
    StudentView getStudentById(@PathVariable Long id) {
        return service.getStudentView(id);
    }


}
