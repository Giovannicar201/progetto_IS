package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;

public interface UtenteService {
    UtenteEntity add(String email, String password, String nome, String cognome);

    UtenteEntity get(String email);

    UtenteEntity update(UtenteEntity utenteEntity,String email);

    void delete(String email);
}
