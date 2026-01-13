package com.cabinet.oltp.controller;

import com.cabinet.oltp.dto.ServiciuDto;
import com.cabinet.oltp.service.CategorieService;
import com.cabinet.oltp.service.ServiciuService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicii")
public class ServiciuController {

    private final ServiciuService serviciuService;
    private final CategorieService categorieService;

    public ServiciuController(ServiciuService serviciuService, CategorieService categorieService) {
        this.serviciuService = serviciuService;
        this.categorieService = categorieService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("servicii", serviciuService.findAll());
        return "oltp/serviciu/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("serviciu", new ServiciuDto());
        model.addAttribute("categorii", categorieService.findAll());

        return "oltp/serviciu/form";
    }

    @PostMapping("/create")
    public String createServiciu(
            @Valid @ModelAttribute("serviciu") ServiciuDto serviciuDto,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categorii", categorieService.findAll());
            return "oltp/serviciu/form";
        }
        serviciuService.saveServiciu(serviciuDto);
        return "redirect:/servicii";
    }

    @GetMapping("/delete/{id}")
    public String deleteServiciu(@PathVariable Long id) {
        serviciuService.deleteServiciuById(id);
        return "redirect:/servicii";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ServiciuDto serviciuDto = serviciuService.findServiciuById(id);
        model.addAttribute("categorii", categorieService.findAll());
        model.addAttribute("serviciu", serviciuDto);
        return "oltp/serviciu/form";
    }

    @PostMapping("/edit/{id}")
    public String updateServiciu(
            @PathVariable Long id, @ModelAttribute("serviciu") ServiciuDto serviciuDto, Model model) {
        model.addAttribute("categorii", categorieService.findAll());
        serviciuService.updateServiciu(id, serviciuDto);
        return "redirect:/servicii";
    }
}
