package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.entities.gestion_academica.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoDTO {

    private Long idCargo;
    private String cargo;

    public CargoDTO() {
    }

    public CargoDTO(Cargo cargo) {
    }

    public CargoDTO toDTO(Cargo cargo) {
        return new CargoDTO(cargo);
    }
}
