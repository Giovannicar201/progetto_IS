package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.*;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EntitaService {
    void creaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws InvalidCollisionException, FolderNotFoundException, InvalidNumberOfPropertyException, NotUniqueEntityException, InvalidEntityNameException, ImageNotFoundException;

    EntitaEntity get(String nomeEntita);

    @Transactional
    void modificaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws EntityNotFoundException, FolderNotFoundException, InvalidEntityNameException, InvalidNumberOfPropertyException, NotUniqueEntityException, ImageNotFoundException, InvalidCollisionException;

    EntitaEntity update(EntitaEntity newEntitaEntity, String nomeEntita);

    void delete(String nomeEntita);

    List<EntitaEntity> findAllEntity(String nomeCartella,String email);

    List<EntitaEntity> findAllEntityByEmail(String email);
}
