package it.unisa.IS_Project.Model.Service;

import org.hamcrest.Condition;
import org.json.simple.parser.ParseException;

import java.util.List;

public interface MatitaService {

    void piazza(String string, String obj, String riga, String colonna) throws ParseException;

    void riempi(String string, String objs);
}
