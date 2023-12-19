package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService{
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public UtenteEntity add(String email,String password,String nome,String cognome){
        UtenteEntity utenteEntity=new UtenteEntity();
        utenteEntity.setEmail(email);
        utenteEntity.setPassword(password);
        utenteEntity.setCognome(cognome);
        utenteEntity.setNome(nome);
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
