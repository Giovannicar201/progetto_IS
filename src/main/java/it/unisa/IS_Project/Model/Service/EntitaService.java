package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.EntitaModel;

import java.util.List;

public interface EntitaService {
    EntitaModel add(EntitaModel entitaModel);

    EntitaModel get(int idEntita);

    EntitaModel update(EntitaModel newEntitaModel,int idEntita);

    void delete(int idEntita);

    List<EntitaModel> findAllEntity(int idCartella);
}
