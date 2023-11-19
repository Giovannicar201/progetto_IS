package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.UtenteModel;

public interface UtenteManager {
    UtenteEntity save(UtenteModel utenteModel);

    UtenteEntity get(String username);

    void delete(String username);
}
