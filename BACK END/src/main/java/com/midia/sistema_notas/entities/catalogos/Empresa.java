package com.midia.sistema_notas.entities.catalogos;


import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.enums.EstadoEmpresa;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING) // Para que en la DB se guarde el texto "ACTIVO", etc.
    @Column(name = "estado")
    private EstadoEmpresa estado = EstadoEmpresa.ACTIVO; // Valor por defecto

    public Empresa(EmpresaDTO empresaDTO) {
        if (empresaDTO != null) {
            this.idEmpresa = empresaDTO.getIdEmpresa();
            this.nombreComercial = empresaDTO.getNombreComercial();
            this.nit = empresaDTO.getNit();
            this.razonSocial = empresaDTO.getRazonSocial();
            this.direccion = empresaDTO.getDireccion();
            this.telefono = empresaDTO.getTelefono();
            this.email = empresaDTO.getEmail();
            this.logo = empresaDTO.getLogo();
        }
    }
    public static Empresa toEntity(EmpresaDTO empresaDTO) {
        return new Empresa(empresaDTO);
    }
}
