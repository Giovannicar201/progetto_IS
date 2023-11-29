package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.ProprietaModel;

public interface ProprietaService {
    ProprietaModel add(ProprietaModel proprietaModel);

    ProprietaModel add2(ProprietaModel proprietaModel,int idProprieta,int idEntita);

    ProprietaModel get(int idProprieta);

    ProprietaModel update(ProprietaModel newProprietaModel,int idProprieta);

    void delete(int idProprieta);
}
