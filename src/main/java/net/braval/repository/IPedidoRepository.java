package net.braval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.braval.model.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido,Integer> {

}
