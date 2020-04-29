package com.hrproj.controller;

import com.hrproj.entity.*;
import com.hrproj.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class WorkerController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private CandidateServiceImpl candidateService;
    @Autowired
    private PayrollServiceImpl payrollService;
    @Autowired
    private TimetableServiceImpl timetableService;
    @Autowired
    private CertificateServiceImpl certificateService;

    @Value("${upload.path}")
    private  String uploadPath;
    @Value("${upload.pathJ}")
    private  String uploadPathJ;


    @GetMapping("/worker")
    public String workerList(Model model) {
        Employee employee = employeeService.getInfoEmployee();
        model.addAttribute("name", employee.getName()+" "+employee.getSurname());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("birthday", format.format(employee.getBirthday()));
        model.addAttribute("mobphone", employee.getMobphone());
        model.addAttribute("email", employee.getEmail());
       model.addAttribute("gender", employee.getGender());
        model.addAttribute("department", employee.getPost().getDepartment());
        model.addAttribute("post", employee.getPost().getPost());
        model.addAttribute("uploadPath",uploadPath);
       model.addAttribute("photo",employee.getPhoto());
        return "employee";
    }
    @GetMapping("/worker/certificate")
    public String  certificateEmployee(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getByEmail(auth.getName());
        model.addAttribute("name", employee.getSurname()+" "+employee.getName());
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        model.addAttribute("date", date);
        return "employee_certificate";
    }
    @GetMapping("/worker/diagram")
    public String  diagramEmployee(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employeeForm", employees);
        List<Candidate> candidates = candidateService.getAll();
        model.addAttribute("candidateForm", candidates);
        return "employee_diagram";
    }
    @GetMapping("/worker/event")
    public String  eventEmployee(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getByEmail(auth.getName());
//        Candidate candidate = candidateService.getByEmail("arianagorodec@gmail.com");
//        Timetable timetable = new Timetable();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//        try {
//            Date date= format.parse("03/04/2020 12:00");
//            LocalDateTime time = LocalDateTime.parse("03/04/2020 12:00",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//            timetable.setDate(date);
//            timetable.setTime(time);
//            timetable.setCandidate(candidate);
//            timetable.setEmployee(employee);
//            timetable.setType("resume");
//            timetableService.addTimetable(timetable);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        List<Timetable> timetables = timetableService.getByTypeAndIdEmployee("resume",employee.getId());
        model.addAttribute("resumeForm", timetables);
        List<Timetable> events = timetableService.getByIdEmployee(employee.getId());
        model.addAttribute("eventForm", events);
        return "employee_event";
    }
    @GetMapping("/worker/report")
    public String  reportEmployee(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getByEmail(auth.getName());
        List<Payroll> payrolls = payrollService.getByIdEmployee(employee.getId());
        model.addAttribute("payrollForm", payrolls);
        return "employee_report";
    }



    @PostMapping("/worker")
    public String addPhoto(@RequestParam("file") MultipartFile file) throws IOException {
        Employee employee = employeeService.getInfoEmployee();
        if (file != null) {
            File uploadDir = new File(uploadPathJ);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPathJ+"/"+resultFileName));

            employee.setPhoto(resultFileName);
            employeeService.updateEmployee(employee);
        }
        return "redirect:/worker";
    }

    @PostMapping("/worker/certificate")
    public String addCertificate(@RequestParam("typeCertificate") String type){ //@RequestParam("numCert") String numCert
        if(type!=null) {
            Employee employee = employeeService.getInfoEmployee();
            Certificate certificate = new Certificate();
            certificate.setOrderDate(new Date());
            certificate.setPercent(0);
            certificate.setType(type);
            certificate.setEmployee(employee);
            certificateService.addCertificate(certificate);
        }
//        else if(numCert!=null){
//
//        }
        return "redirect:/worker/certificate";
    }

    @PostMapping("/worker/event")
    public String setEvent(@RequestParam("dateStart") String dateStart,
                           @RequestParam("timeStart") String timeStart,
                           @RequestParam("dateEnd") String dateEnd,
                           @RequestParam("timeEnd") String timeEnd,
                           @RequestParam("type") String type) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getByEmail(auth.getName());
        Timetable timetable = new Timetable();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String[] colors = {"#FFDEAD","#ADD8E6","#4fab40", "#DDA0DD"};
        Random random = new Random();
        try {
            String start = dateStart+" "+timeStart;
            String end = dateEnd+" "+timeEnd;
            Date dateS= format.parse(start);
            LocalDateTime timeS = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            Date dateE= format.parse(end);
            LocalDateTime timeE = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            timetable.setStartDate(dateS);
            timetable.setStartTime(timeS);
            timetable.setEndDate(dateE);
            timetable.setEndTime(timeE);
            timetable.setEmployee(employee);
            timetable.setType(type);
            timetable.setColor(colors[random.nextInt(colors.length)]);
            timetableService.addTimetable(timetable);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/worker/event";
    }
}
