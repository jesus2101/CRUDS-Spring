package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Personaje;

public interface IPersonajeRepository extends JpaRepository<Personaje,Integer> {

}
