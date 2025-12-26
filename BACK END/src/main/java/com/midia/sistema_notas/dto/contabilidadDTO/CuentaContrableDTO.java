package com.midia.sistema_notas.dto.contabilidadDTO;


import com.midia.sistema_notas.entities.contabilidad.CuentaContrable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CuentaContrableDTO {
    private Long idCuenta;
    private Long codigoPuc;
    private String nombreCuenta;
    private String tipoCuenta;
    private String naturaleza;

    public CuentaContrableDTO() {
    }

    public CuentaContrableDTO(CuentaContrable cuentaContrable) {
    }

    public CuentaContrableDTO toDTO(CuentaContrable cuentaContrable) {
        return new CuentaContrableDTO(cuentaContrable);
    }
}
