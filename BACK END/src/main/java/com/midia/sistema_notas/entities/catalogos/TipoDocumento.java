package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_documento")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Long idTipoDocumento;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "cod_tipo_documento")
    private String codTipoDocumento;
}
