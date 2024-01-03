package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagine.InvalidFileSizeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface ImmagineService {
    void caricaImmagine(MultipartFile foto, String email) throws SQLException, IOException, InvalidFileSizeException;

    void integraPixelArt(MultipartFile foto, String nomeFoto, String email);

    ImmagineEntity get(String nomeFoto);

    String visualizzaListaImmagini(String email) throws SQLException;
}
