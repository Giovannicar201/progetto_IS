package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;

import java.util.List;

public interface CartellaService {
    CartellaEntity add(String nomeCartella,String email);
    
    CartellaEntity get(String nomeCartella);
    
    CartellaEntity update(CartellaEntity newCartellaEntity,String nomeCartella);

    void delete(String nomeCartella);

    List<CartellaEntity> getAllCartelle(String email);
}
