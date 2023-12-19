package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.CartellaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartellaServiceImpl implements CartellaService{
    @Autowired
    private CartellaRepository cartellaRepository;
    @Autowired
    private UtenteRepository utenteRepository;


    @Override
    @Transactional
    public CartellaEntity add(String nomeCartella,String email) {
        CartellaEntity cartellaEntity=new CartellaEntity();
        cartellaEntity.setNome(nomeCartella);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);
        cartellaEntity.setUtenteEntity(utenteEntity);

        cartellaRepository.save(cartellaEntity);

        return cartellaEntity;
    }

    @Override
    @Transactional
    public CartellaEntity get(String nomeCartella) {
        CartellaEntity cartellaEntity=cartellaRepository.findByNome(nomeCartella).get();
        return cartellaEntity;
    }

    @Override
    @Transactional
    public CartellaEntity update(CartellaEntity newCartellaEntity,String nomeCartella) {
        CartellaEntity cartellaEntity=cartellaRepository.findByNome(nomeCartella).get();
        newCartellaEntity.setNome(nomeCartella);
        cartellaEntity.setNome(newCartellaEntity.getNome());
        CartellaEntity saved=cartellaRepository.save(cartellaEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeCartella) {
        cartellaRepository.deleteByNome(nomeCartella);
    }

    @Override
    @Transactional
    public List<CartellaEntity> getAllCartelle(String email){
        return cartellaRepository.findAllByEmail(email);
    }
}
