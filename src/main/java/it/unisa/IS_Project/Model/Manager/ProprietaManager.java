package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Model.Model.ProprietaModel;

public interface ProprietaManager {
    ProprietaEntity save(ProprietaModel proprietaModel);

    ProprietaEntity get(String nomeProprieta);

    void delete(String nomeProprieta);
}
