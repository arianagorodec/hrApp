package com.hrproj.controller;

import com.hrproj.entity.User;
import com.hrproj.service.impl.MailSenderServiceIml;
import com.hrproj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class RestoreController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MailSenderServiceIml mailSender;

    @GetMapping("/restore")
    public String restorePass(Model model) {
        return "restore";
    }

    @PostMapping("/restore")
    public String sendMessage(@RequestParam("username") String username, Model model) {


        User user = userService.getByUsername(username);

        if (user == null) {
            model.addAttribute("usernameError", "Пользователь с таким email не существует");
            return "redirect:/restore";
        } else {
            user.setActivationCode(UUID.randomUUID().toString());
            userService.editUser(user);

            String message = String.format("Здравствуйте, $s!\n"
                    + "Вот ваша ссылка на восстановление пароля: " +
                    "http://localhost:8080/activate/%s", user.getUsername(), user.getActivationCode());
            mailSender.sendActivationPage(username, message);

            //}

            return "/";
        }
    }

    @GetMapping("/restore/{code}")
    public String restore(Model model, @PathVariable String code){
        boolean isActivated = userService.activatedUser(code);
        return "/logout";
    }
}
