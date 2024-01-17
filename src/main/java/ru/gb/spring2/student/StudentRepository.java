package ru.gb.spring2.student;

import java.util.List;
import java.util.ArrayList;

public class StudentRepository {
    final List<Student> students=new ArrayList<>();
    public static int index=0;

    public static Integer getIndex() {
        return ++index;
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(String id) {
        return students.stream()
                .filter(todo -> todo.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    public Student create(Student todo) {
        todo.id = StudentRepository.getIndex().toString();
        students.add(todo);
        return todo;
    }

    public Student update(Student student) {
        Student updateStudent = findById(student.id);
        if (updateStudent != null) {
            updateStudent.firstName = student.firstName;
            updateStudent.lastName = student.lastName;
        }
        return updateStudent;
    }

    public boolean delete(String id) {
        Student student = findById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
