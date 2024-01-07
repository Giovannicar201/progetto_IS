package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Exception.GMP.GST.InvalidColumnException;
import org.json.simple.parser.ParseException;

import java.sql.SQLException;
import java.util.List;

public interface MatitaService {

    String piazza(String email, String string, String obj, String riga, String colonna) throws ParseException, EntityNotFoundException, InvalidColumnException, InvalidRowException, SQLException;

    void riempi(String string, List<String> objs);

    String visualizzaLista(String email, String string) throws SQLException;
}
