package de.neuefische;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDB {

    private List<Student> students;

    public StudentDB(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public boolean addStudent(Student student){
        return students.add(student);
    }

    public void removeStudentWithId(int id){
        for (Student s:students) {
            if (s.getId() == id){
                students.remove(s);
            }
        }
    }
    public boolean removeStudent(Student student){
        return students.remove(student);
    }

    @Override
    public String toString() {
        return "StudentDB{" +
                "students=" + students +
                '}';
    }
}
