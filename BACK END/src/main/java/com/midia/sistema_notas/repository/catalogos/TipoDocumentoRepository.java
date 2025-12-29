package com.midia.sistema_notas.repository.catalogos;

import com.midia.sistema_notas.entities.catalogos.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Long> {

    @Query("SELECT t FROM TipoDocumento t WHERE t.tipoDocumento = :name")
    Optional<TipoDocumento> findByName(String name);
}
