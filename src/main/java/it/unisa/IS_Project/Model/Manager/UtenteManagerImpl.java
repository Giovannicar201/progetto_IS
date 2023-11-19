package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.UtenteModel;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteManagerImpl implements UtenteManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UtenteEntity save(UtenteModel utenteModel) {
        UtenteEntity utenteEntity=modelMapper.map(utenteModel,UtenteEntity.class);
        return utenteRepository.save(utenteEntity);
    }

    @Override
    public UtenteEntity get(String username) {
        return utenteRepository.findAllByUsername(username).orElseThrow(()->new RuntimeException("Utente non trovato"));
    }

    @Override
    public void delete(String username) {
        if(utenteRepository.existsById(username)){
            utenteRepository.deleteById(username);
        }
    }
}
