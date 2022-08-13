package demo.controller;

import demo.entity.Student;
import demo.exc.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // base request mapping
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data after bean creation
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (0 > studentId || studentId >= students.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }
}