package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Animal;

public interface IAnimalRepository extends JpaRepository<Animal,Integer>{

}
