package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;

public interface MappaService {
    String creaMappa(String email, String nome, int lunghezza, int larghezza);

    String visualizzaStatisticheMappa(String email);

    MappaEntity get(String nome);

    MappaEntity update(MappaEntity newMappaEntity, String nomeMappa);
}
