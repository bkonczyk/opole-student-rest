package pl.sda.spring.students.domain.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.spring.students.domain.student.Student;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer hours;
    private Integer mark;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
