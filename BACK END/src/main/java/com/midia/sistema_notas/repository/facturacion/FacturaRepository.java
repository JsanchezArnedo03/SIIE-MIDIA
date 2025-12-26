package com.midia.sistema_notas.repository.facturacion;


import com.midia.sistema_notas.entities.facturacion.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {

}
