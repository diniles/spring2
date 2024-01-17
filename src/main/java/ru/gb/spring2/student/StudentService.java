package ru.gb.spring2.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repo = repository;
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student getStudentById(String id) {
        return repo.findById(id);
    }

    public Student create(Student student) {
        return repo.create(student);
    }

    public Student update(Student student) {
        return repo.update(repo.update(student));
    }

    public boolean delete(String id) {
        return repo.delete(id);
    }
}
