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
    private String proprieta;
    private String collisione;

    private List<ComprendeModel> idEntitaComprende;

    private List<ComponeModel> idEntitaCompone;

    private List<ProprietaModel> idEntitaProprieta;

    private List<ContieneModel> idEntitaContiene;

    private List<ImmagineEntitaModel> idEntitaFoto;
}
