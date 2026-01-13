package com.cabinet.oltp.controller;

import com.cabinet.oltp.service.IncasareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/incasari")
public class IncasareController {

    private final IncasareService incasareService;

    public IncasareController(IncasareService incasareService) {
        this.incasareService = incasareService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("incasari", incasareService.findAll());
        return "oltp/incasare/list";
    }
}
