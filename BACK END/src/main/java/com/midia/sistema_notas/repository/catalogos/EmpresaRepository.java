package com.midia.sistema_notas.repository.catalogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.midia.sistema_notas.entities.catalogos.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{}
