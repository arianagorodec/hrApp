package com.hrproj.controller;

import com.hrproj.entity.Anketa;
import com.hrproj.entity.Candidate;
import com.hrproj.entity.User;
import com.hrproj.service.impl.AnketaServiceImpl;
import com.hrproj.service.impl.CandidateServiceImpl;
import com.hrproj.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CandidateServiceImpl candidateService;
    @Autowired
    private AnketaServiceImpl anketaService;

    @Value("${upload.path}")
    private  String uploadPath;
    @Value("${upload.pathJ}")
    private  String uploadPathJ;
    @Value("${upload.path.anketa}")
    private  String uploadPathAnketa;
    @Value("${upload.path.anketaJ}")
    private  String uploadPathAnketaJ;

    @GetMapping("/user")
    public String userList(Model model) {
        Candidate candidate = candidateService.getInfoCandidate();
        model.addAttribute("name", candidate.getName()+" "+candidate.getSurname());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("birthday", format.format(candidate.getBirthday()));
        model.addAttribute("mobphone", candidate.getMobphone());
        model.addAttribute("email", candidate.getEmail());
       model.addAttribute("gender", candidate.getGender());
        model.addAttribute("uploadPath",uploadPath);
       model.addAttribute("photo",candidate.getPhoto());
        return "user";
    }
    @GetMapping("/user/quest")
    public String  questUser(Model model) {
        Candidate candidate = candidateService.getInfoCandidate();
        Anketa anketa = anketaService.getByIdCandidateForForm(candidate.getId());
        if(anketa!=null)
            model.addAttribute("anketa", anketa);
        else
            model.addAttribute("anketa", new Anketa());
        model.addAttribute("name", candidate.getName()+" "+candidate.getSurname());
        return "user_quest";
    }
    @GetMapping("/user/message")
    public String  messageUser(Model model) {
        return "user_message";
    }



    @PostMapping("/user")
    public String addPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        Candidate candidate = candidateService.getInfoCandidate();
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


    @PostMapping("/user/quest")
    public String  questUser(@ModelAttribute("anketa") @Valid Anketa anketa, BindingResult bindingResult,
          @RequestParam("file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "user_quest";
        }
        Candidate candidate = candidateService.getInfoCandidate();
        if (file != null) {
            File uploadDir = new File(uploadPathAnketaJ);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPathAnketaJ+"/"+resultFileName));

            anketa.setResume(resultFileName);
            anketa.setCandidate(candidate);
            Anketa oldAnketa = anketaService.getByIdCandidate(candidate.getId());
            if(oldAnketa!=null) {
                oldAnketa.setAnketa(anketa);
                anketaService.updateAnketaFromForm(oldAnketa);
            }
            else
                anketaService.updateAnketaFromForm(anketa);
        }
        return "user_quest";
    }

}
