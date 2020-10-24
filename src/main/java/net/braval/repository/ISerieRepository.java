package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Serie;

public interface ISerieRepository extends JpaRepository<Serie,Integer> {

}
