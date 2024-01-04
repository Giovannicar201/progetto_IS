package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.CreazioneMappa.InvalidMapHeightException;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.CreazioneMappa.InvalidMapNameException;
import it.unisa.IS_Project.Model.Exception.GMP.GMP.CreazioneMappa.InvalidMapWidthException;
import org.json.simple.parser.ParseException;

import java.sql.SQLException;

public interface MappaService {
    String creaMappa(String email, String nome, String lunghezza, String larghezza) throws InvalidMapNameException, InvalidMapWidthException, InvalidMapHeightException;

    String visualizzaStatisticheMappa(String mappa) throws ParseException;

    MappaEntity update(MappaEntity newMappaEntity, String nomeMappa);
}
