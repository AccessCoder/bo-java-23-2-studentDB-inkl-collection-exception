package de.neuefische;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {



    @Test
    void getAllStudents() {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new ArrayList<>(List.of(
                        new Student("a", 1)
                ))
        );
        List<Student> expected = new ArrayList<>(List.of(
                new Student("a", 1)
        ));
        //WHEN
        List<Student> actual = studentDB.getAllStudents();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void removeStudent() {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new ArrayList<>(List.of(
                        new Student("a", 1)
                ))
        );
        //WHEN
        boolean actual = studentDB.removeStudent(
                new Student("a", 1));
        //THEN
        assertTrue(actual);
        assertEquals(List.of(), studentDB.getAllStudents());

    }

    @Test
    void addStudent() {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new ArrayList<>(List.of(
                        new Student("a", 1)
                ))
        );
        Student student = new Student("B", 2);
        List<Student> expected = new ArrayList<>(List.of(
                new Student("a", 1),
                student
        ));
        //WHEN
        boolean actual = studentDB.addStudent(student);
        //THEN
        assertTrue(actual);
        assertEquals(expected, studentDB.getAllStudents());
    }


}