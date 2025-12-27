package com.midia.sistema_notas.dto.catalogosDTO;


import com.midia.sistema_notas.entities.catalogos.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpresaDTO {
    private Long idEmpresa;
    private String nombreComercial;
    private String nit;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String email;
    private byte[] logo;

    public EmpresaDTO() {
    }

    public EmpresaDTO(Empresa empresa) {
        if (empresa != null) {
            this.idEmpresa = empresa.getIdEmpresa();
            this.nombreComercial = empresa.getNombreComercial();
            this.nit = empresa.getNit();
            this.razonSocial = empresa.getRazonSocial();
            this.direccion = empresa.getDireccion();
            this.telefono = empresa.getTelefono();
            this.email = empresa.getEmail();
            this.logo = empresa.getLogo();
        }
    }

    public static EmpresaDTO toDTO(Empresa empresa) {
        return new EmpresaDTO(empresa);
    }

}
