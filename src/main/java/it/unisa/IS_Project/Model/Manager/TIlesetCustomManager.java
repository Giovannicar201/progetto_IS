package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.TilesetCustomEntity;
import it.unisa.IS_Project.Model.Model.TilesetCustomModel;

public interface TIlesetCustomManager {
    TilesetCustomEntity save(TilesetCustomModel tilesetCustomModel);

    TilesetCustomEntity get(int idTilesetCustom);

    void delete(int idTilesetCustom);
}
