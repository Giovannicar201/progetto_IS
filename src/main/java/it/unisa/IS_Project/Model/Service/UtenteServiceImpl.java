package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.UtenteModel;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public UtenteModel add(UtenteModel utenteModel) {
        UtenteEntity utenteEntity=modelMapper.map(utenteModel,UtenteEntity.class);
        utenteRepository.save(utenteEntity);
        return modelMapper.map(utenteEntity,UtenteModel.class);
    }

    @Override
    @Transactional
    public UtenteModel get(String email) {
        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        return modelMapper.map(utenteEntity,UtenteModel.class);
    }

    @Override
    @Transactional
    public UtenteModel update(UtenteModel newUtenteModel, String email) {
        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        newUtenteModel.setEmail(email);
        utenteEntity.setPassword(newUtenteModel.getPassword());
        UtenteEntity saved=utenteRepository.save(utenteEntity);
        return modelMapper.map(saved,UtenteModel.class);
    }

    @Override
    @Transactional
    public void delete(String email) {
        utenteRepository.deleteById(email);
    }
}
