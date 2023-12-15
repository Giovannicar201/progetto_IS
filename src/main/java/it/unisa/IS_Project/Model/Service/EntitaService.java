package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Model.EntitaModel;

import java.util.List;

public interface EntitaService {
    EntitaEntity add(String nome,String collisione,String coordinate,String email,String nomeFoto,String nomeCartella);

    EntitaEntity get(String nomeEntita);

    EntitaEntity update(EntitaEntity newEntitaEntity,String nomeEntita);

    void delete(String nomeEntita);

    List<EntitaEntity> findAllEntity(String nomeCartella);
}
