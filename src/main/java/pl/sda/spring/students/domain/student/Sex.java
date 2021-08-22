package pl.sda.spring.students.domain.student;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Sex {
    M("male"), F("female");

    private String gender;
}
