package com.midia.sistema_notas.repository.facturacion;


import com.midia.sistema_notas.entities.facturacion.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura,Long> {

}
