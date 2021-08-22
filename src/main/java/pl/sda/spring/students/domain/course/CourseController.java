package pl.sda.spring.students.domain.course;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    void addCourse(@RequestBody Course course) {
        courseService.add(course);
    }

    @PostMapping("/student/{studentId}")
    void addCourseToStudent(@RequestBody Course course, @PathVariable Long studentId) {
        courseService.addToStudent(course, studentId);
    }
}
