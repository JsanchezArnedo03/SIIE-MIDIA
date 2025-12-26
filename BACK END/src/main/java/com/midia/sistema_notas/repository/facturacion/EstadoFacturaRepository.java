package com.midia.sistema_notas.repository.facturacion;


import com.midia.sistema_notas.entities.facturacion.EstadoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoFacturaRepository extends JpaRepository<EstadoFactura,Long> {

}
