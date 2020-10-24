package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Empresa;

public interface IEmpresaRepository extends JpaRepository<Empresa,Integer> {

}
