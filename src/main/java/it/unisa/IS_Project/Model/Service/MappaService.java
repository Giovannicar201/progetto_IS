package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Model.MappaModel;

public interface MappaService {
    MappaEntity add(String nome,int lunghezza,int larghezza,String email);

    MappaEntity get(String nome);

    MappaEntity update(MappaEntity newMappaEntity, String nomeMappa);

    void delete(String nomeMappa);
}
