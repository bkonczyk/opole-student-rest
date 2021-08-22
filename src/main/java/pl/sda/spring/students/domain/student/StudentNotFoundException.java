package pl.sda.spring.students.domain.student;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id) {
        super("Student with id: " + id + " was not found");
    }
}
