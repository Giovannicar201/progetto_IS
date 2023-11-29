package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntitaModel {
    private int idEntita;
    private String nome;
    private String collisione;
    private String coordinate;

    private List<ProprietaModel> idEntitaProprieta;

    private MappaModel mappaModels;

    private CartellaModel CartellaEntita;

    private ImmagineModel idFoto;
}
