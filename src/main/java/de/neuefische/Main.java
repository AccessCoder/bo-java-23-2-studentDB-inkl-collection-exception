package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IdAlreadyExistsException {
        Map<Integer, Student> testMap = new HashMap<>();
        Student a = new Student("a", 1);
        Student b = new Student("b", 2);
        testMap.put(a.getId(), a);
        testMap.put(b.getId(), b);

        StudentDB studentDB = new StudentDB(testMap);

        System.out.println(studentDB.getAllStudents());
        Student c = new Student("c", 2);

        try {
            studentDB.addStudent(c);
        } catch (IdAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }


    }
}