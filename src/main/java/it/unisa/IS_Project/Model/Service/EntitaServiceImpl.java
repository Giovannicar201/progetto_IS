package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.*;
import it.unisa.IS_Project.Model.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntitaServiceImpl implements EntitaService{
    @Autowired
    private EntitaRepository entitaRepository;
    @Autowired
    private MappaRepository mappaRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private ImmagineRepository immagineRepository;
    @Autowired
    private CartellaRepository cartellaRepository;

    @Override
    @Transactional
    public EntitaEntity add(String nome,String collisione,String coordinate,String email,String nomeFoto,String nomeCartella){
        EntitaEntity entitaEntity=new EntitaEntity();
        entitaEntity.setNome(nome);
        entitaEntity.setCollisione(collisione);
        entitaEntity.setCoordinate(coordinate);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);
        entitaEntity.setEmail(utenteEntity);

        MappaEntity mappaEntity=mappaRepository.findAllByEmail(email);
        mappaEntity.setId(mappaEntity.getId());
        entitaEntity.setIdMappaEntity(mappaEntity);

        ImmagineEntity immagineEntity=immagineRepository.findByNomeAndEmail(nomeFoto,email).get();
        immagineEntity.setIdFoto(immagineEntity.getIdFoto());
        immagineEntity.setNome(nomeFoto);
        entitaEntity.setImmagineEntita(immagineEntity);

        CartellaEntity cartellaEntity=cartellaRepository.findAllByEmailAndNome(email,nomeCartella).get();
        cartellaEntity.setId(cartellaEntity.getId());
        cartellaEntity.setNome(nomeCartella);
        entitaEntity.setCartellaEntity(cartellaEntity);

        entitaRepository.save(entitaEntity);

        return entitaEntity;
    }

    @Override
    @Transactional
    public EntitaEntity get(String nomeEntita) {
        EntitaEntity entitaEntity=entitaRepository.findByNome(nomeEntita).orElse(null);
        return entitaEntity;
    }

    @Override
    @Transactional
    public EntitaEntity update(EntitaEntity newEntitaEntity,String nomeEntita) {
        EntitaEntity entitaEntity=entitaRepository.findByNome(nomeEntita).orElse(null);
        newEntitaEntity.setNome(nomeEntita);
        entitaEntity.setNome(newEntitaEntity.getNome());
        entitaEntity.setCollisione(newEntitaEntity.getCollisione());
        EntitaEntity saved=entitaRepository.save(entitaEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeEntita) {
        entitaRepository.deleteByNome(nomeEntita);
    }

    @Override
    @Transactional
    public List<EntitaEntity> findAllEntity(String nomeCartella,String email){
        return entitaRepository.findAllByCartellaEntity(nomeCartella,email);
    }

    @Override
    @Transactional
    public List<EntitaEntity> findAllEntityByEmail(String email){
        return entitaRepository.findAllByEmail(email);
    }
}
