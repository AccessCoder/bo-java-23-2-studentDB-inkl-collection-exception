package de.neuefische;

import java.util.Arrays;

public class StudentDB {

    private Student[] students;

    public StudentDB(Student[] students) {
        this.students = students;
    }

    public Student[] getAllStudents() {
        return students;
    }

    @Override
    public String
    toString() {
        return "StudentDB{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
}
