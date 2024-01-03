package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.*;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.*;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Repository.*;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
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
    public void creaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws InvalidCollisionException, FolderNotFoundException, InvalidNumberOfPropertyException, NotUniqueEntityException, InvalidEntityNameException, ImageNotFoundException {
        EntitaEntity entitaEntity = new EntitaEntity();
        EntitaEntity entitaEntityQuery = entitaRepository.findByNome(nome);
        ImmagineEntity immagineEntityQuery = immagineRepository.findByNome(nomeImmagine);
        CartellaEntity cartellaEntityQuery = cartellaRepository.findByNome(nomeCartella);
        UtenteEntity utenteEntity = utenteRepository.findByEmail(email);

        if(immagineEntityQuery == null)
            throw new ImageNotFoundException("ERRORE - IMMAGINE NON ESISTENTE.");

        if(!Validator.isEntityNameValid(nome))
            throw new InvalidEntityNameException("ERRORE - NOME NON VALIDO.");

        if(entitaEntityQuery != null)
            throw new NotUniqueEntityException("ERRORE - ENTITÀ GIÀ ESISTENTE.");

        if(!Validator.isCollisionValid(collisioni))
            throw new InvalidCollisionException("ERRORE - COLLISIONI NON VALIDE.");

        if(cartellaEntityQuery == null)
            throw new FolderNotFoundException("ERRORE - CARTELLA NON ESISTENTE.");

        if(!Validator.isNumberOfPropertyValid(nomiProprieta.size()))
            throw new InvalidNumberOfPropertyException("ERRORE - NUMERO DI PROPRIETÀ NON VALIO.");

        entitaEntity.setEmail(utenteEntity);
        entitaEntity.setImmagineEntita(immagineEntityQuery);
        entitaEntity.setNome(nome);
        entitaEntity.setCollisione(collisioni);
        entitaEntity.setCartellaEntity(cartellaEntityQuery);

        Iterator<String> iteratoreNomi = nomiProprieta.iterator();
        Iterator<String> iteratoreValori = valoriProprieta.iterator();

        while (iteratoreNomi.hasNext() && iteratoreValori.hasNext()) {
            String nomeProprieta = iteratoreNomi.next();
            String valoreProprieta = iteratoreValori.next();

            ProprietaEntity proprietaEntity = new ProprietaEntity();

            proprietaEntity.setNome(nomeProprieta);
            proprietaEntity.setValore(valoreProprieta);
            proprietaEntity.setEntita(entitaEntity);
        }

        entitaRepository.save(entitaEntity);
    }

    @Override
    @Transactional
    public void modificaEntita(String email, String nomeImmagine, String nome, String collisioni, String nomeCartella, List<String> nomiProprieta, List<String> valoriProprieta) throws EntityNotFoundException, FolderNotFoundException, InvalidEntityNameException, InvalidNumberOfPropertyException, NotUniqueEntityException, ImageNotFoundException, InvalidCollisionException {
        EntitaEntity entitaEntityQuery = entitaRepository.findByNome(nome);

        if(entitaEntityQuery == null)
            throw new EntityNotFoundException("ERRORE - ENTITÀ NON ESISTENTE.");

        entitaRepository.delete(entitaEntityQuery);

        MappaEntity mappaEntity = entitaEntityQuery.getIdMappaEntity();

        creaEntita(email,nomeImmagine,nome,collisioni,nomeCartella,nomiProprieta,valoriProprieta);
        entitaEntityQuery = entitaRepository.findByNome(nome);
        entitaEntityQuery.setIdMappaEntity(mappaEntity);
    }

    @Override
    @Transactional
    public void eliminaEntita(String nome) throws EntityNotFoundException {
        EntitaEntity entitaEntityQuery = entitaRepository.findByNome(nome);

        if(entitaEntityQuery == null)
            throw new EntityNotFoundException("ERRORE - ENTITÀ NON ESISTENTE.");

        entitaRepository.delete(entitaEntityQuery);
    }

    @Override
    @Transactional
    public EntitaEntity get(String nome) {
        return entitaRepository.findByNome(nome);
    }

    @Override
    @Transactional
    public String visualizzaListaEntitaInCartella(String email, String nomeCartella) throws SQLException {
        JSONObject immaginiJSON = new JSONObject();
        JSONArray blobImmagini = new JSONArray();

        List<EntitaEntity> entita = entitaRepository.findAllByCartellaEntity(email,nomeCartella);

        for(EntitaEntity entitaEntity : entita) {
            JSONObject immagineJSON = new JSONObject();

            Blob immagine = entitaEntity.getImmagineEntita().getFoto();
            byte[] bytes = immagine.getBytes(1, (int) immagine.length());

            immagineJSON.put(entitaEntity.getNome(), Base64.getEncoder().encodeToString(bytes));

            blobImmagini.add(immagineJSON);
        }

        immaginiJSON.put("blobImmagini", blobImmagini);

        return immaginiJSON.toString();
    }

    @Override
    @Transactional
    public String visualizzaListaEntita(String email) throws SQLException {
        JSONObject immaginiJSON = new JSONObject();
        JSONArray blobImmagini = new JSONArray();

        List<EntitaEntity> entita = entitaRepository.findAllByEmail(email);

        for(EntitaEntity entitaEntity : entita) {
            JSONObject immagineJSON = new JSONObject();

            Blob immagine = entitaEntity.getImmagineEntita().getFoto();
            byte[] bytes = immagine.getBytes(1, (int) immagine.length());

            immagineJSON.put(entitaEntity.getNome(), Base64.getEncoder().encodeToString(bytes));

            blobImmagini.add(immagineJSON);
        }

        immaginiJSON.put("blobImmagini", blobImmagini);

        return immaginiJSON.toString();
    }
}
