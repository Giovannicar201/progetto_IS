package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Exception.InvalidFolderNameException;

import java.util.List;

public interface CartellaService {
    CartellaEntity creaCartella(String nomeCartella, String email) throws InvalidFolderNameException;
    
    CartellaEntity get(String nomeCartella);
    
    CartellaEntity update(CartellaEntity newCartellaEntity,String nomeCartella);

    void delete(String nomeCartella);

    List<CartellaEntity> getAllCartelle(String email);
}
