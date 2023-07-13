package de.neuefische;

import java.util.*;

public class StudentDB {

    private Map<Integer, Student> students;

    public StudentDB(Map<Integer, Student> students) {
        this.students = students;
    }

    public Map<Integer, Student> getAllStudents() {
        return students;
    }

    public Student addStudent(Student student) throws IdAlreadyExistsException {
        if (students.containsKey(student.getId())){
            throw new IdAlreadyExistsException("Student with ID: " + student.getId() + " already exists");
        }
        students.put(student.getId(),student);
        return students.get(student.getId());
    }

    public Student removeStudent(int id) throws IdNotFoundException {
        if (students.containsKey(id)){
            return students.remove(id);
        }
       throw new IdNotFoundException("No User Found, with ID: " + id);
    }

    @Override
    public String toString() {
        return "StudentDB{" +
                "students=" + students +
                '}';
    }
}
