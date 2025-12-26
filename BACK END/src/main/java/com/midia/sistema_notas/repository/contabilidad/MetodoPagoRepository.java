package com.midia.sistema_notas.repository.contabilidad;

import com.midia.sistema_notas.entities.contabilidad.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago,Long> {

}
