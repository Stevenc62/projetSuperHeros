package com.steven.projetSuperHeros.controller;

import com.steven.projetSuperHeros.model.Hero;
import com.steven.projetSuperHeros.model.Incidents;
import com.steven.projetSuperHeros.repository.HeroRepository;
import com.steven.projetSuperHeros.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HeroController {

    @Autowired
    HeroRepository _heroRepository;
    
    @Autowired
    IncidentRepository _incidentRepository;

    @RequestMapping("/heroes")
    public String getHeroes(Model model) {
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes",heroes);
        return ("heroes");
    }

    @GetMapping("/ajout_hero")
    public String formHero(Model model) {
        Hero hero = new Hero();
        model.addAttribute("hero", hero);
        List<Incidents> incidents = (List<Incidents>) _incidentRepository.findAll();
        model.addAttribute("incidents",incidents);
        return "ajout_hero";
    }

    @PostMapping("/submit")
    public RedirectView submitHero(@ModelAttribute Hero hero, Model model) {
        _heroRepository.save(hero);
        return new RedirectView("heroes");
    }
}