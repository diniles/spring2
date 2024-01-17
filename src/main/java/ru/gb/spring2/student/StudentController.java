package ru.gb.spring2.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    ResponseEntity<?> notFound() {
        return ResponseEntity.badRequest().body("Not found");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = service.getStudents();
        return ResponseEntity.ok(students);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Student student) {
        Student created = service.create(student);
        return ResponseEntity.ok(created);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Student student) {
        Student updated = service.update(student);
        if (updated == null) {
            return notFound();
        }
        return ResponseEntity.ok(updated);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        boolean result = service.delete(id);
        if (result) {
            return ResponseEntity.ok("Deleted");
        } else {
            return notFound();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        Student student = service.getStudentById(id);
        if (student == null) {
            return notFound();
        }
        return ResponseEntity.ok(student);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> welcomePage() {
        return ResponseEntity.ok("Hello, in Student app!");
    }
}
