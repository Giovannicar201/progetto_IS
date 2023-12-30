package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UtenteServiceImpl implements UtenteService{
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public UtenteEntity add(String email,String password,String nome) throws NoSuchAlgorithmException {
        UtenteEntity utenteEntity = new UtenteEntity();
        utenteEntity.setEmail(email);
        utenteEntity.setNome(nome);
        String passwordCrip=UtilityClass.cryptAlg(password);

        utenteEntity.setPassword(passwordCrip);

        utenteRepository.save(utenteEntity);
        return utenteEntity;
    }

    @Override
    @Transactional
    public UtenteEntity get(String email) {
        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        return utenteEntity;
    }

    @Override
    @Transactional
    public UtenteEntity update(UtenteEntity newUtenteEntity, String email) {
        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        newUtenteEntity.setEmail(email);
        utenteEntity.setPassword(newUtenteEntity.getPassword());
        UtenteEntity saved=utenteRepository.save(utenteEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String email) {
        utenteRepository.deleteById(email);
    }
}
