package com.tpp.UniversityStr.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.tpp.UniversityStr.models.Curators;
import com.tpp.UniversityStr.service.CuratorService;

import java.util.Optional;

@Controller
@RequestMapping("/curators")
public class CuratorController {

    @Autowired
    private CuratorService curatorService;

    @GetMapping
    public String listCurators(Model model) {
        model.addAttribute("curators", curatorService.getAllCurators());
        return "curators";
    }

    @GetMapping("/add")
    public String addCuratorForm(Model model) {
        model.addAttribute("curator", new Curators());
        return "add-curator";
    }

    @PostMapping("/add")
    public String addCurator(@Valid @ModelAttribute Curators curator, BindingResult result) {
        if (result.hasErrors()) {
            return "add-curator";
        }
        curatorService.saveCurator(curator);
        return "redirect:/curators";
    }

    @GetMapping("/edit/{id}")
    public String editCuratorForm(@PathVariable Integer id, Model model) {
        Optional<Curators> curatorOpt = curatorService.findCuratorById(id);
        if (curatorOpt.isPresent()) {
            model.addAttribute("curator", curatorOpt.get());
            return "edit-curator";
        }
        return "redirect:/curators";
    }

    @PostMapping("/update/{id}")
    public String updateCurator(@PathVariable Integer id, @Valid @ModelAttribute Curators curator,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "edit-curator";
        }
        curator.setCuratorId(id);
        curatorService.updateCurator(curator);
        return "redirect:/curators";
    }

    @GetMapping("/delete/{id}")
    public String deleteCurator(@PathVariable Integer id) {
        curatorService.deleteCuratorById(id);
        return "redirect:/curators";
    }
}
