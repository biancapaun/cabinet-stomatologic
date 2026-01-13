package com.cabinet.oltp.controller;

import com.cabinet.oltp.service.PacientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    PacientService pacientService;

    public HomeController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping("")
    public String showHomePage(Model model) {
        model.addAttribute("pacienti", pacientService.findAll().size());
        return "home";
    }
}
