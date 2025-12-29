package com.midia.sistema_notas.repository.catalogos;


import com.midia.sistema_notas.entities.catalogos.CondicionPsicologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondicionPsicologicaRepository extends JpaRepository<CondicionPsicologica,Long> {

    @Query("SELECT c FROM CondicionPsicologica c WHERE c.condicionPsicologica = :condicionPsicologica")
    Optional<CondicionPsicologica> findByName(String condicionPsicologica);
}
