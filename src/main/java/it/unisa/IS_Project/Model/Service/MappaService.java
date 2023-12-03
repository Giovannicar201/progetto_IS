package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.MappaModel;

public interface MappaService {
    MappaModel add(MappaModel mappaModel);

    MappaModel get(int idMappa);

    MappaModel update(MappaModel newMappaModel,int idMappa);

    void delete(int idMappa);
}
