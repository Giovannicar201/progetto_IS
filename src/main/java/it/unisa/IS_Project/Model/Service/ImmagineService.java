package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Exception.GEN.GIM.NotUniqueImageException;
import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Exception.GEN.GIM.InvalidFileSizeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface ImmagineService {
    void caricaImmagine(MultipartFile immagine, String email) throws SQLException, IOException, InvalidFileSizeException, NotUniqueImageException;

    void integraPixelArt(MultipartFile immagine, String nomeFoto, String email);

    ImmagineEntity get(String nome, String email);

    String visualizzaListaImmagini(String email) throws SQLException;
}
