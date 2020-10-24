package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo,Integer> {

}
