package com.steven.projetSuperHeros.repository;

import com.steven.projetSuperHeros.model.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incidents, Integer> {
}
