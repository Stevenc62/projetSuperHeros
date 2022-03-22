package com.steven.projetSuperHeros.repository;

import com.steven.projetSuperHeros.model.Hero;
import com.steven.projetSuperHeros.model.Incidents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Integer> {
    List<Hero> findByPseudo(String pseudo);
}
