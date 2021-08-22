package pl.sda.spring.students.domain.student;

class StudentMapper {

    static StudentView mapToStudentView(Student student) {
        return StudentView.of(
                student.getId(),
                student.getName(),
                student.getLastName(),
                student.getSex(),
                student.getCourses());
    }

    static Student mapRequestToStudent(StudentRequest request) {
        return Student.builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .sex(request.getSex())
                .build();
    }

    static StudentListView mapToStudentListView(Student student) {
        return StudentListView.of(
                student.getId(),
                student.getName(),
                student.getLastName(),
                student.getSex());
    }
}
