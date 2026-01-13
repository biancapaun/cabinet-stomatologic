package com.cabinet.oltp.controller;

import com.cabinet.oltp.dto.PacientDto;
import com.cabinet.oltp.service.PacientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacienti")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pacienti", pacientService.findAll());
        return "oltp/pacient/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("pacient", new PacientDto());
        return "oltp/pacient/form";
    }

    @PostMapping("/create")
    public String createPacient(
            @Valid @ModelAttribute("pacient") PacientDto pacientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "oltp/pacient/form";
        }
        pacientService.savePacient(pacientDto);
        return "redirect:/pacienti";
    }

    @GetMapping("/delete/{id}")
    public String deletePacient(@PathVariable Long id) {
        pacientService.deletePacientById(id);
        return "redirect:/pacienti";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        PacientDto pacientDto = pacientService.findPacientById(id);
        model.addAttribute("pacient", pacientDto);
        return "oltp/pacient/form";
    }

    @PostMapping("/edit/{id}")
    public String updatePacient(
            @PathVariable Long id, @ModelAttribute("pacient") PacientDto pacientDto) {
        pacientService.updatePacient(id, pacientDto);
        return "redirect:/pacienti";
    }
}
