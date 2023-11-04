package it.unisa.IS_Project.Model.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TilesetCustomModel {
    private int id;
    private String nome;

    private List<ComprendeModel> idTilesetCustomComprende;

    private List<CreaModel> idTilesetCustomCrea;
}
