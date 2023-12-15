package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.ImmagineModel;
import it.unisa.IS_Project.Model.Repository.ImmagineRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;

@Service
public class ImmagineServiceImpl implements ImmagineService{
    @Autowired
    private ImmagineRepository immagineRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public ImmagineEntity add(Blob foto,String nomeFoto,String email) {
        ImmagineEntity immagineEntity=new ImmagineEntity();
        immagineEntity.setNome(nomeFoto);
        immagineEntity.setFoto(foto);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);
        immagineEntity.setEmail(utenteEntity);

        immagineRepository.save(immagineEntity);
        return immagineEntity;
    }

    @Override
    @Transactional
    public ImmagineEntity get(String nomeFoto){
        ImmagineEntity immagineEntity=immagineRepository.findByNome(nomeFoto).get();
        return immagineEntity;
    }

    @Override
    @Transactional
    public ImmagineEntity update(ImmagineEntity newImmagineEntity,String nomeFoto) {
        ImmagineEntity immagineEntity=immagineRepository.findByNome(nomeFoto).get();
        newImmagineEntity.setNome(nomeFoto);
        immagineEntity.setFoto(newImmagineEntity.getFoto());
        immagineEntity.setNome(newImmagineEntity.getNome());
        ImmagineEntity saved=immagineRepository.save(immagineEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeFoto) {
        immagineRepository.deleteByNome(nomeFoto);
    }
}
