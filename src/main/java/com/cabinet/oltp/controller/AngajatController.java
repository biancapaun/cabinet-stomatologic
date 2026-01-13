package com.cabinet.oltp.controller;

import com.cabinet.oltp.service.AngajatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/angajati")
public class AngajatController {

    private final AngajatService angajatService;

    public AngajatController(AngajatService angajatService) {
        this.angajatService = angajatService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("angajati", angajatService.findAll());
        return "oltp/angajat/list";
    }
}
