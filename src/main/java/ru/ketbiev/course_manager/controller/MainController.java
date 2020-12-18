package ru.ketbiev.course_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ketbiev.course_manager.entity.Student;
import ru.ketbiev.course_manager.entity.Teacher;
import ru.ketbiev.course_manager.service.InterfaceService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private InterfaceService<Teacher> interfaceService;

    @RequestMapping("/")
    public String showAllEmployee(Model model) {
        List<Teacher> teacher = interfaceService.getAll();
        //System.out.println(teacher.toString());
        model.addAttribute("allT", teacher);
        return "authorization";
    }

    @RequestMapping("/teacher")
    public String addTeacher(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "add-teacher";
    }

    @RequestMapping("/student")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

}
