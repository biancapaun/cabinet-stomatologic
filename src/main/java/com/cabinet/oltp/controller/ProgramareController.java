package com.cabinet.oltp.controller;

import com.cabinet.oltp.dto.ProgramareDto;
import com.cabinet.oltp.service.MedicService;
import com.cabinet.oltp.service.PacientService;
import com.cabinet.oltp.service.ProgramareService;
import com.cabinet.oltp.service.ServiciuService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/programari")
public class ProgramareController {

    private final ProgramareService programareService;
    private final ServiciuService serviciuService;
    private final PacientService pacientService;
    private final MedicService medicService;

    public ProgramareController(
            ProgramareService programareService,
            ServiciuService serviciuService,
            PacientService pacientService,
            MedicService medicService) {
        this.programareService = programareService;
        this.serviciuService = serviciuService;
        this.pacientService = pacientService;
        this.medicService = medicService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("programari", programareService.findAll());
        return "oltp/programare/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("programare", new ProgramareDto());
        model.addAttribute("pacienti", pacientService.findAll());
        model.addAttribute("servicii", serviciuService.findAll());
        model.addAttribute("medici", medicService.findAll());
        return "oltp/programare/form";
    }

    @PostMapping("/create")
    public String createProgramare(
            @Valid @ModelAttribute("programare") ProgramareDto dto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pacienti", pacientService.findAll());
            model.addAttribute("servicii", serviciuService.findAll());
            model.addAttribute("medici", medicService.findAll());
            return "oltp/programare/form";
        }
        programareService.saveProgramare(dto);
        return "redirect:/programari";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ProgramareDto programareDto = programareService.findProgramareById(id);
        model.addAttribute("programare", programareDto);
        model.addAttribute("pacienti", pacientService.findAll());
        model.addAttribute("servicii", serviciuService.findAll());
        model.addAttribute("medici", medicService.findAll());
        return "oltp/programare/form";
    }

    @PostMapping("/edit/{id}")
    public String updateProgramare(
            @PathVariable Long id,
            @ModelAttribute("programare") ProgramareDto programareDto,
            Model model) {
        model.addAttribute("pacienti", pacientService.findAll());
        model.addAttribute("servicii", serviciuService.findAll());
        model.addAttribute("medici", medicService.findAll());
        programareService.updateProgramare(id, programareDto);
        return "redirect:/programari";
    }

    @GetMapping("/delete/{id}")
    public String deleteParogramare(@PathVariable Long id) {
        programareService.deleteProgramareById(id);
        return "redirect:/programari";
    }
}
