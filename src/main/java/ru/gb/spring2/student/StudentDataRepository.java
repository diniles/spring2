package ru.gb.spring2.student;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDataRepository extends StudentRepository{
    public StudentDataRepository() {
        super();
        students.add(addStudent("01","Daniel", "Löble"));
        students.add(addStudent("02","Sascha", "Gerstner"));
        students.add(addStudent("03","Andi", "Deris"));
        students.add(addStudent("04","Michael", "Kiske"));
        students.add(addStudent("05","Kai", "Hansen"));
        students.add(addStudent("06","Markus", "Grosskopf"));
        students.add(addStudent("07","Michael", "Weikath"));
    }
        static Student addStudent (String id, String firstName, String lastName) {
            Student student=new Student();
            student.id=id;
            student.firstName= firstName;
            student.lastName=lastName;
            return student;
        }
}
