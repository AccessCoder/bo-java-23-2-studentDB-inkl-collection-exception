package de.neuefische;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {



    @Test
    void getAllStudents() {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new HashMap<>(Map.of(1,
                        new Student("a", 1)
                ))
        );
        Map<Integer,Student> expected = new HashMap<>(Map.of(
                1,new Student("a", 1)
        ));
        //WHEN
        Map<Integer,Student> actual = studentDB.getAllStudents();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void removeStudent() throws Exception {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new HashMap<>(Map.of(1,
                        new Student("a", 1)
                ))
        );
        //WHEN
        Student actual = studentDB.removeStudent(1);
        //THEN
        assertEquals(new Student("a", 1), actual);
        assertEquals(Map.of(), studentDB.getAllStudents());

    }

    @Test
    void removeStudent_ShouldThrowIdNotFoundException_WhenInvalidIdIsGiven(){
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new HashMap<>(Map.of(1,
                        new Student("a", 1)
                ))
        );
        //WHEN //THEN
        try {
            studentDB.removeStudent(7);
            fail();
        }catch (IdNotFoundException e){
            assertTrue(true);
        }


    }

    @Test
    void addStudent() throws IdAlreadyExistsException {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new HashMap<>(Map.of(1,
                        new Student("a", 1)
                ))
        );
        Student student = new Student("B", 2);
        Map<Integer,Student> expected = new HashMap<>(Map.of(1,
                new Student("a", 1),
                2, student
        ));
        //WHEN
        Student actual = studentDB.addStudent(student);
        //THEN
        assertEquals(student,actual);
        assertEquals(expected, studentDB.getAllStudents());
    }

    @Test
    void addStudent_ShouldThrowIdAlreadyExistsException_WhenIdIsAlreadyInTheMap() {
        //GIVEN
        StudentDB studentDB = new StudentDB(
                new HashMap<>(Map.of(1,
                        new Student("a", 1)
                ))
        );
        Student student = new Student("B", 1);

        //WHEN

        try {
            studentDB.addStudent(student);
            fail();
        } catch (IdAlreadyExistsException e) {
            assertTrue(true);
        }

    }


}