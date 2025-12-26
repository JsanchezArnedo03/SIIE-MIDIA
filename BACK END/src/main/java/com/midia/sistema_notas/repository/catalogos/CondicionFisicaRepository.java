package com.midia.sistema_notas.repository.catalogos;

import com.midia.sistema_notas.entities.catalogos.CondicionFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionFisicaRepository extends JpaRepository<CondicionFisica,Long> {
}