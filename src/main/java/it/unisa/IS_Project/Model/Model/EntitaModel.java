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

    private List<ProprietaModel> idEntitaProprieta;

    private TilesetCustomModel tilesetCustomEntita;

    private TilesetPremiumModel tilesetPremiumEntita;

    private List<PiazzatoModel> idEntitaPiazzato;

    private List<ImmagineEntitaModel> idEntitaFoto;
}
