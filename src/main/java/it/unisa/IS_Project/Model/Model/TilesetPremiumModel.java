package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TilesetPremiumModel {
    private int id;
    private String nome;
    private double prezzo;

    private List<CompraModel> tilesetPremiumList;

    private EntitaModel idTilesetPremiumEntita;
}
