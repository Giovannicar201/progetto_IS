package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.InvalidFolderNameException;
import it.unisa.IS_Project.Model.Exception.GMP.GCR.CreaCartella.NotUniqueFolderException;

public interface CartellaService {
    void creaCartella(String nome, String email) throws InvalidFolderNameException, NotUniqueFolderException;

    String visualizzaListaCartelle(String email);

    CartellaEntity get(String nome, String email);

    CartellaEntity get(int id);
}
