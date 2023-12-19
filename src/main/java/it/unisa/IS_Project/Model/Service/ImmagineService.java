package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;

import java.sql.Blob;

public interface ImmagineService {
    ImmagineEntity add(Blob foto, String nomeFoto, String email);

    ImmagineEntity get(String nomeFoto);

    ImmagineEntity update(ImmagineEntity newImmagineEntity, String nomeFoto);

    void delete(String nomeFoto);
}
