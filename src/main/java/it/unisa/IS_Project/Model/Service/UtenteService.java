package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;

import java.security.NoSuchAlgorithmException;

public interface UtenteService {
    UtenteEntity add(String email, String password, String nome) throws NoSuchAlgorithmException;

    UtenteEntity get(String email);

    UtenteEntity update(UtenteEntity utenteEntity,String email);

    void delete(String email);
}
