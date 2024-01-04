package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.InvalidColumnException;
import org.hamcrest.Condition;
import org.json.simple.parser.ParseException;

import java.util.List;

public interface MatitaService {

    void piazza(String string, String obj, String riga, String colonna) throws ParseException, EntityNotFoundException, InvalidColumnException, InvalidRowException;

    void riempi(String string, List<String> objs);
}
