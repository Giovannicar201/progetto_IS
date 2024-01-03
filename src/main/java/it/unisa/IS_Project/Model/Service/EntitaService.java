package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.*;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface EntitaService {
    void creaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws InvalidCollisionException, FolderNotFoundException, InvalidNumberOfPropertyException, NotUniqueEntityException, InvalidEntityNameException, ImageNotFoundException;

    void modificaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws EntityNotFoundException, FolderNotFoundException, InvalidEntityNameException, InvalidNumberOfPropertyException, NotUniqueEntityException, ImageNotFoundException, InvalidCollisionException;

    void eliminaEntita(String nome) throws EntityNotFoundException;

    String visualizzaEntita(String nome) throws EntityNotFoundException;

    String visualizzaListaEntitaInCartella(String email, String nomeCartella) throws SQLException;

    String visualizzaListaEntita(String email) throws SQLException;
}
