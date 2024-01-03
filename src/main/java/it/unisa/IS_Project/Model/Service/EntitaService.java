package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.*;

import java.util.List;

public interface EntitaService {
    void creaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws InvalidCollisionException, FolderNotFoundException, InvalidNumberOfPropertyException, NotUniqueEntityException, InvalidEntityNameException, ImageNotFoundException;

    EntitaEntity get(String nomeEntita);

    EntitaEntity update(EntitaEntity newEntitaEntity,String nomeEntita);

    void delete(String nomeEntita);

    List<EntitaEntity> findAllEntity(String nomeCartella,String email);

    List<EntitaEntity> findAllEntityByEmail(String email);
}
