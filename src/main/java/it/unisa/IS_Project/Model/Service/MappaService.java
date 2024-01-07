package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapHeightException;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapNameException;
import it.unisa.IS_Project.Exception.GMP.GMP.InvalidMapWidthException;
import org.json.simple.parser.ParseException;

public interface MappaService {
    String creaMappa(String email, String nome, String lunghezza, String larghezza) throws InvalidMapNameException, InvalidMapWidthException, InvalidMapHeightException;

    String visualizzaStatisticheMappa(String mappa) throws ParseException;

    MappaEntity update(MappaEntity newMappaEntity, String nomeMappa);

    MappaEntity get(String email);
}
