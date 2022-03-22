package com.steven.projetSuperHeros.controller;

import com.steven.projetSuperHeros.model.Hero;
import com.steven.projetSuperHeros.model.Incidents;
import com.steven.projetSuperHeros.repository.HeroRepository;
import com.steven.projetSuperHeros.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MapController {

    @Autowired
    HeroRepository _heroRepository;
    @Autowired
    IncidentRepository _incidentRepository;

    @RequestMapping("/map")
    public String showMapPage(Model model) {
        List<Hero> heroes = (List<Hero>) _heroRepository.findAll();
        model.addAttribute("heroes",heroes);
        return "map.html";
    }

    @GetMapping("/creer_accident")
    public String formIncident(Model model) {
        Incidents incident = new Incidents();
        String incidentType = incident.getType();
        model.addAttribute("incident", incidentType);

        List<Incidents> incidents = (List<Incidents>) _incidentRepository.findAll();
        model.addAttribute("incidents",incidents);
        return "creer_accident.html";
    }

    @PostMapping("/submitIncident")
    public String submitIncident(Model model, Integer chosenIncidentId, String incidentLatitude, String incidentLongitude) {

        System.out.println(incidentLatitude + " " + incidentLongitude);
        model.addAttribute("incidentLatitude", incidentLatitude);
        model.addAttribute("incidentLongitude", incidentLongitude);

        String redirectionString = "/creer_accident";

        if( chosenIncidentId == null )
        {
            System.out.println("null");
            List<Incidents> incidents = (List<Incidents>) _incidentRepository.findAll();
            model.addAttribute("incidents",incidents);
            redirectionString = "/creer_accident";
        }
        else
        {
            Incidents chosenIncident = _incidentRepository.getById(chosenIncidentId);
            System.out.println(chosenIncident);

            List<Hero> heroesThatCanDoThisIncident = chosenIncident.getHeroes();
            System.out.println(heroesThatCanDoThisIncident.toString());

            List<Hero> heroes = (List<Hero>) heroesThatCanDoThisIncident;
            System.out.println(heroes);
            model.addAttribute("heroes",heroesThatCanDoThisIncident);

            redirectionString = "/map";

        }

        return (redirectionString);
    }
}
