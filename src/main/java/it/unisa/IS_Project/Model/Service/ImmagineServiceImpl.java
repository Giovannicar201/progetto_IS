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

@Service
public class ImmagineServiceImpl implements ImmagineService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ImmagineRepository immagineRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public ImmagineModel add(ImmagineModel immagineModel) {
        ImmagineEntity immagineEntity=modelMapper.map(immagineModel,ImmagineEntity.class);
        immagineRepository.save(immagineEntity);
        return modelMapper.map(immagineEntity, ImmagineModel.class);
    }

    @Override
    @Transactional
    public ImmagineModel add2(ImmagineModel immagineModel,int idFoto,String email){
        ImmagineEntity immagineEntity=modelMapper.map(immagineModel,ImmagineEntity.class);
        immagineEntity.setIdFoto(idFoto);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);

        immagineEntity.setEmail(utenteEntity);

        immagineRepository.save(immagineEntity);
        return modelMapper.map(immagineEntity,ImmagineModel.class);
    }

    @Override
    @Transactional
    public ImmagineModel get(int idFoto) {
        ImmagineEntity immagineEntity=immagineRepository.findById(idFoto).get();
        return modelMapper.map(immagineEntity,ImmagineModel.class);
    }

    @Override
    @Transactional
    public ImmagineModel update(ImmagineModel newImmagineModel, int idFoto) {
        ImmagineEntity immagineEntity=immagineRepository.findById(idFoto).get();
        newImmagineModel.setIdFoto(idFoto);
        immagineEntity.setFoto(newImmagineModel.getFoto());
        ImmagineEntity saved=immagineRepository.save(immagineEntity);
        return modelMapper.map(saved, ImmagineModel.class);
    }

    @Override
    @Transactional
    public void delete(int idFoto) {
        immagineRepository.deleteById(idFoto);
    }
}
