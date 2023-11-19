package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.PiazzatoEntity;
import it.unisa.IS_Project.Model.Model.PiazzatoModel;

public interface PiazzatoManager {
    PiazzatoEntity save(PiazzatoModel piazzatoModel);

    PiazzatoEntity get(int idMappa,int idEntita,String coordinate);

    void delete(int idMappa,int idEntita,String coordinate);
}
