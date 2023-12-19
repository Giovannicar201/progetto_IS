package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ProprietaEntity;

public interface ProprietaService {
    ProprietaEntity add(String nomeProprieta,String valore,int idEntita);

    ProprietaEntity get(String nomeProprieta);

    ProprietaEntity update(ProprietaEntity newProprietaEntity,String nomeProprieta);

    void delete(String nomeProprieta);
}
