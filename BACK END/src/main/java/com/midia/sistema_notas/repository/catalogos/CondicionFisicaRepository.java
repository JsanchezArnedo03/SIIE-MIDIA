package com.midia.sistema_notas.repository.catalogos;

import com.midia.sistema_notas.entities.catalogos.CondicionFisica;
import com.midia.sistema_notas.entities.catalogos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondicionFisicaRepository extends JpaRepository<CondicionFisica, Long> {
    @Query("SELECT c FROM CondicionFisica c WHERE condicion_fisica = :name")
    Optional<CondicionFisica> findByName(String name);
}