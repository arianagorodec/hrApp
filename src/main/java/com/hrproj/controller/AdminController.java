package com.hrproj.controller;

import com.hrproj.entity.Log;
import com.hrproj.service.LogService;
import com.hrproj.service.UserService;
import com.hrproj.service.impl.CandidateServiceImpl;
import com.hrproj.service.impl.EmployeeServiceImpl;
import com.hrproj.service.impl.LogServiceImpl;
import com.hrproj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    LogServiceImpl logService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private CandidateServiceImpl candidateService;


    @GetMapping("/admin")
    public String userList(Model model) {
        List<Log> logs = logService.getByInfo("Вошёл");
        model.addAttribute("logs", logs);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Log log = new Log();
        log.setInfo("Вошёл");
        log.setUser(userService.getByUsername(auth.getName()));
        log.setTime(new Date());
        logService.addLog(log);
        return "admin";
    }
    @GetMapping("/admin/2")
    public String admin2(Model model) {
        model.addAttribute("allUsers", userService.allUsers());

        return "admin_2";
    }
    @GetMapping("/admin/changes")
    public String adminchanges(Model model) {
        model.addAttribute("changes", logService.getAll());

        return "admin_changes";
    }
    @GetMapping("/admin/employee")
    public String workEmployee(Model model) {
        model.addAttribute("employees", employeeService.getAll());

        return "admin_employee";
    }
    @GetMapping("/admin/user")
    public String workUser(Model model) {
        model.addAttribute("candidates", candidateService.getAll());

        return "admin_user";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Log log = new Log();
        log.setInfo("Вышел");
        log.setUser(userService.getByUsername(auth.getName()));
        log.setTime(new Date());
        logService.addLog(log);
        return "/";
    }

}
