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
    }

    public EmpresaDTO toDTO(Empresa empresa) {
        return new EmpresaDTO(empresa);
    }
}
