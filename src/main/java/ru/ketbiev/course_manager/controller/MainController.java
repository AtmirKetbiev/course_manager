package ru.ketbiev.course_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ketbiev.course_manager.entity.User;
import ru.ketbiev.course_manager.service.SecurityService;
import ru.ketbiev.course_manager.service.UserService;
import ru.ketbiev.course_manager.validator.UserValidator;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult,
                               Model model) {
        userValidator.validate(userForm, bindingResult);
        System.out.println("validate ok");
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error!=null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        if (logout!=null) {
            model.addAttribute("massage", "Logger out successfully");
        }

        return "login";
    }

    @RequestMapping(value = "/q", method = RequestMethod.GET)
    public String returnName() {
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

//    @Autowired
//    private InterfaceService<Teacher> interfaceService;
//
//    @RequestMapping("/")
//    public String showAllEmployee(Model model) {
//        List<Teacher> teacher = interfaceService.getAll();
//        //System.out.println(teacher.toString());
//        model.addAttribute("allT", teacher);
//        return "authorization";
//    }
//
//    @RequestMapping("/teacher")
//    public String addTeacher(Model model) {
//        Teacher teacher = new Teacher();
//        model.addAttribute("teacher", teacher);
//        return "add-teacher";
//    }
//
//    @RequestMapping("/student")
//    public String addStudent(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "add-student";
//    }

}
