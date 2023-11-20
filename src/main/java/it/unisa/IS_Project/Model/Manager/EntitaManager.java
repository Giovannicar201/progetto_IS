package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Model.EntitaModel;

public interface EntitaManager {
    EntitaEntity save(EntitaModel entitaModel);

    EntitaEntity get(int idEntita);

    void delete(int idEntita);
}
