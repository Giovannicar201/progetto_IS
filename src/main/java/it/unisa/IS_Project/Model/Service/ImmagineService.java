package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.ImmagineModel;

public interface ImmagineService {
    ImmagineModel add(ImmagineModel immagineModel);

    ImmagineModel add2(ImmagineModel immagineModel,int idFoto,String email);

    ImmagineModel get(int idFoto);

    ImmagineModel update(ImmagineModel newImmagineModel,int idFoto);

    void delete(int idFoto);
}
