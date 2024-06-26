package com.lekarskaOrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lekarskaOrd.entity.TerminiList;
import com.lekarskaOrd.service.TerminiListService;

@Controller
public class TerminiListController {
    
    @Autowired
    private TerminiListService service;
    
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/termini";
    }
    
    @RequestMapping("/editTerminList/{id}")
    public String editTermina(@PathVariable("id") int id, Model model) {
        TerminiList tr = service.getTerminById(id);
        model.addAttribute("termini", tr);
        return "TerminEdit";
    }

    @RequestMapping(value = "/updateTermin", method = RequestMethod.POST)
    public String updateTermin(@ModelAttribute("termini") TerminiList termin) {
        service.saveTermini(termin);
        return "redirect:/termini";
    }
}
