package com.midia.sistema_notas.repository.gestion_academica;


import com.midia.sistema_notas.entities.catalogos.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Long> {

}
