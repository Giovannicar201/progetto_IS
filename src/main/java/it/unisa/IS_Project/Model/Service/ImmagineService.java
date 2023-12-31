package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

public interface ImmagineService {
    ImmagineEntity add(Part foto, String nomeFoto, String email) throws IOException;

    ImmagineEntity get(String nomeFoto);

    ImmagineEntity update(ImmagineEntity newImmagineEntity, String nomeFoto);

    void delete(String nomeFoto);
    List<ImmagineEntity> getAllImmagini(String email);

}
