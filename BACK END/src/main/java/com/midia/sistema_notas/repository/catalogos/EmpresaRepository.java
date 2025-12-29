package com.midia.sistema_notas.repository.catalogos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.midia.sistema_notas.entities.catalogos.Empresa;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

    @Query("SELECT e FROM empresa e where e.nit = :nit")
    Optional<Empresa> findByNit(String nit);
}
