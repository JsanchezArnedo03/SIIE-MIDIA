package com.midia.sistema_notas.entities.contabilidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "metodo_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private Long id;
    @Column(name = "metodo_pago")
    private String metodo;
}
