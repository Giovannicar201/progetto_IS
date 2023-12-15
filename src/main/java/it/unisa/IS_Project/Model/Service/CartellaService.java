package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Model.CartellaModel;

import java.util.Optional;

public interface CartellaService {
    CartellaEntity add(String nomeCartella,String email);
    
    CartellaEntity get(String nomeCartella);
    
    CartellaEntity update(CartellaEntity newCartellaEntity,String nomeCartella);

    void delete(String nomeCartella);
}
