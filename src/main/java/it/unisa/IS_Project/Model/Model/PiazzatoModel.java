package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiazzatoModel {
    private MappaModel idMappaPiazzato;
    private EntitaModel idEntitaPiazzato;
    private String cordinate;
}
