package com.lekarskaOrd.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.lekarskaOrd.entity.Pacijent;
import com.lekarskaOrd.entity.TerminiList;
import com.lekarskaOrd.service.PacijentService;
import com.lekarskaOrd.service.TerminiListService;

@Controller
public class PacijentController {
	
	
	@Autowired
	private PacijentService service;
	
	@Autowired
	private TerminiListService TerminiService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/dodaj_pacijenta")
	public String dodajPacijenta() {
		return "dodajPacijenta";
	}
	@GetMapping("/pacijenti")
	public ModelAndView getAllPacijent() {
		List<Pacijent>list=service.getAllPacijent();
		return new ModelAndView("pacijenti","pacijent",list);
	}
	
	@GetMapping("/termini")
	public String getTermini(Model model) {
		
		List<TerminiList>list=TerminiService.getAllTermini();
		model.addAttribute("termini",list);
		return "Termini";
	}
	
	@PostMapping("/save")
	public String addPacijent(@ModelAttribute Pacijent p) {
		service.save(p);
		return "redirect:/pacijenti";
	}
	
	@RequestMapping("/lista/{id}")
	public String getTerminiList(@PathVariable("id") int id) {
		Pacijent p=service.getPacijentById(id);
		TerminiList tl = new TerminiList(p.getId(),p.getIme(),p.getPrezime(),p.getPol(),p.getJmbg(),"01/01/2024","00:00");
		TerminiService.saveTermini(tl);
		return "redirect:/termini";
	}
	
	@RequestMapping("/PacijentEdit/{id}")
	public String editPacijenta(@PathVariable("id") int id, Model model) {
		
		Pacijent p = service.getPacijentById(id);
		model.addAttribute("pacijent",p);
		return "PacijentEdit";
	}
	
	@RequestMapping("/deletePacijent/{id}")
	public String deletePacijent(@PathVariable("id") int id) {
		
		service.deleteById(id);
		return "redirect:/pacijenti";
	}
	
}
