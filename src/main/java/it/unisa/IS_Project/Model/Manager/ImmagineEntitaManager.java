package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ImmagineEntitaEntity;
import it.unisa.IS_Project.Model.Model.ImmagineEntitaModel;

public interface ImmagineEntitaManager {
    ImmagineEntitaEntity save(ImmagineEntitaModel immagineEntitaModel);

    ImmagineEntitaEntity get(int idImmagineEntita);

    void delete(int idImmagineEntita);
}
