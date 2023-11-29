package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.CartellaModel;
import it.unisa.IS_Project.Model.Model.UtenteModel;
import it.unisa.IS_Project.Model.Repository.CartellaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartellaServiceImpl implements CartellaService{
    @Autowired
    private CartellaRepository cartellaRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CartellaModel add(CartellaModel cartellaModel) {
        CartellaEntity cartellaEntity=modelMapper.map(cartellaModel,CartellaEntity.class);
        cartellaRepository.save(cartellaEntity);
        return modelMapper.map(cartellaEntity,CartellaModel.class);
    }

    @Override
    @Transactional
    public CartellaModel add2(CartellaModel cartellaModel,String nomeCartella,String email){
        CartellaEntity cartellaEntity=modelMapper.map(cartellaModel,CartellaEntity.class);
        cartellaEntity.setNome(nomeCartella);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);

        cartellaEntity.setUtenteEntity(utenteEntity);

        cartellaRepository.save(cartellaEntity);
        return modelMapper.map(cartellaEntity,CartellaModel.class);
    }

    @Override
    @Transactional
    public CartellaModel get(int idCartella) {
        CartellaEntity cartellaEntity=cartellaRepository.findAllById(idCartella).get();
        return modelMapper.map(cartellaEntity,CartellaModel.class);
    }

    @Override
    @Transactional
    public CartellaModel update(CartellaModel newCartellaModel,int idCartella) {
        CartellaEntity cartellaEntity=cartellaRepository.findAllById(idCartella).orElse(null);
        newCartellaModel.setId(idCartella);
        cartellaEntity.setNome(newCartellaModel.getNome());
        CartellaEntity saved=cartellaRepository.save(cartellaEntity);
        return modelMapper.map(saved,CartellaModel.class);
    }

    @Override
    @Transactional
    public void delete(int idCartella) {
        cartellaRepository.deleteById(idCartella);
    }
}
