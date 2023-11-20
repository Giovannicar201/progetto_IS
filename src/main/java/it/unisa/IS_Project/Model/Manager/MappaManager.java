package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Model.MappaModel;

public interface MappaManager {
    MappaEntity save(MappaModel mappaModel);

    MappaEntity get(int idMappa);

    void delete(int idMappa);
}
