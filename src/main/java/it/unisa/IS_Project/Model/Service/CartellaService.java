package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.CartellaModel;

import java.util.Optional;

public interface CartellaService {
    CartellaModel add(CartellaModel cartellaModel);

    CartellaModel add2(CartellaModel cartellaModel,String nomeCartella,String email);
    
    CartellaModel get(int idCartella);
    
    CartellaModel update(CartellaModel newCartellaModel,int idCartella);

    void delete(int idCartella);
}
