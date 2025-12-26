package com.midia.sistema_notas.entities.catalogos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "empresa")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name="nit")
    private String nit;
    
    @Column(name = "razon_social")
    private String razonSocial;
    
    @Column(name = "direccion")
    private String direccion;

    @Column(name="telefono")
    private String telefono;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "logo")
    private byte[] logo;
    
}
