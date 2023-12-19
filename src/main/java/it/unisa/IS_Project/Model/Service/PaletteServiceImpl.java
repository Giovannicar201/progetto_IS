package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.PaletteRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaletteServiceImpl implements PaletteService{
    @Autowired
    private PaletteRepository paletteRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public PaletteEntity add(String nomePalette,String email){
        PaletteEntity paletteEntity= new PaletteEntity();
        paletteEntity.setNomePalette(nomePalette);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);

        paletteEntity.setEmailUtente(utenteEntity);

        paletteRepository.save(paletteEntity);
        return paletteEntity;
    }

    @Override
    @Transactional
    public PaletteEntity get(String nomePalette) {
        PaletteEntity paletteEntity=paletteRepository.findByNomePalette(nomePalette).get();
        return paletteEntity;
    }

    @Override
    @Transactional
    public PaletteEntity update(PaletteEntity newPaletteEntity,String nomePalette) {
        PaletteEntity paletteEntity=paletteRepository.findByNomePalette(nomePalette).get();
        newPaletteEntity.setNomePalette(nomePalette);
        paletteEntity.setNomePalette(newPaletteEntity.getNomePalette());
        PaletteEntity saved=paletteRepository.save(paletteEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomePalette) {
        paletteRepository.deleteByNomePalette(nomePalette);
    }
}
