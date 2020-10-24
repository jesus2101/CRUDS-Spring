package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}
