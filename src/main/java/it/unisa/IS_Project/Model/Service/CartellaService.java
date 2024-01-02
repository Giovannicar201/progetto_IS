package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.InvalidFolderNameException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.NotUniqueFolderException;
import org.json.simple.JSONObject;

import java.util.List;

public interface CartellaService {
    void creaCartella(String nomeCartella, String email) throws InvalidFolderNameException, NotUniqueFolderException;

    String visualizzaListaCartelle(String email);

    CartellaEntity get(String nomeCartella);
    
    CartellaEntity update(CartellaEntity newCartellaEntity,String nomeCartella);
}
