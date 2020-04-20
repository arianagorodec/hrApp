package com.hrproj.controller;

import com.hrproj.entity.Candidate;
import com.hrproj.entity.User;
import com.hrproj.service.impl.CandidateServiceImpl;
import com.hrproj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CandidateServiceImpl candidateService;

    @Value("${upload.path}")
    private  String uploadPath;
    @Value("${upload.pathJ}")
    private  String uploadPathJ;

    @GetMapping("/user")
    public String userList(Model model) {
        Candidate candidate = getInfoCandidate();
        model.addAttribute("name", candidate.getName()+" "+candidate.getSurname());
        model.addAttribute("birthday", candidate.getBirthday());
        model.addAttribute("mobphone", candidate.getMobphone());
        model.addAttribute("email", candidate.getEmail());
       model.addAttribute("gender", candidate.getGender());
        model.addAttribute("uploadPath",uploadPath);
       model.addAttribute("photo",candidate.getPhoto());
        return "user";
    }
    @GetMapping("/user/quest")
    public String  questUser(Model model) {
        Candidate candidate = getInfoCandidate();
        model.addAttribute("name", candidate.getName()+" "+candidate.getSurname());
        return "user_quest";
    }
    @GetMapping("/user/message")
    public String  messageUser(Model model) {
        return "user_message";
    }

    public Candidate getInfoCandidate(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Candidate candidate = candidateService.getByEmail(auth.getName());
        return candidate;
    }

    @PostMapping("/user")
    public String addPhoto(@AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file) throws IOException {
        Candidate candidate = getInfoCandidate();
        if (file != null) {
            File uploadDir = new File(uploadPathJ);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPathJ+"/"+resultFileName));

            candidate.setPhoto(resultFileName);
            candidateService.updateCandidate(candidate);
        }
        return "redirect:/user";
    }

}
