package hu.unideb.web;

import hu.unideb.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface StudentController {

//    @RequestMapping(
//            method = RequestMethod.GET,
//            path = "api/student"
//    ) alatta ez egyszerűbb, de ugyanaz
    @GetMapping("/api/student")
    List<Student> getAll();

    @GetMapping("/api/student/{neptun}")
    Student getOne(@PathVariable String neptun);
}
