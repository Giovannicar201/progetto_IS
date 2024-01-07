package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Exception.GEN.GEN.*;
import it.unisa.IS_Project.Model.Entity.EntitaEntity;

import java.sql.SQLException;
import java.util.List;

public interface EntitaService {
    void creaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws InvalidCollisionException, FolderNotFoundException, InvalidNumberOfPropertyException, NotUniqueEntityException, InvalidEntityNameException, ImageNotFoundException, ImageAlreadyUsedException;

    void modificaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws EntityNotFoundException, FolderNotFoundException, InvalidEntityNameException, InvalidNumberOfPropertyException, NotUniqueEntityException, ImageNotFoundException, InvalidCollisionException, ImageAlreadyUsedException;

    void eliminaEntita(String nome, String email) throws EntityNotFoundException;

    String visualizzaEntita(String nome, String email) throws EntityNotFoundException;

    String visualizzaListaEntitaInCartella(String email, String nomeCartella) throws SQLException;

    String visualizzaListaEntita(String email) throws SQLException;

    EntitaEntity get(String nome, String email);

    EntitaEntity get(int id);
}
