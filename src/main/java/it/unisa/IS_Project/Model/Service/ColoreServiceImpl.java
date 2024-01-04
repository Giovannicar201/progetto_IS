package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;
import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import it.unisa.IS_Project.Model.Repository.ColoreRepository;
import it.unisa.IS_Project.Model.Repository.PaletteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColoreServiceImpl implements ColoreService{
    @Autowired
    private ColoreRepository coloreRepository;
    @Autowired
    private PaletteRepository paletteRepository;

    @Override
    @Transactional
    public ColoreEntity add(String esadecimale,int idPalette){

        ColoreEntity coloreEntity=new ColoreEntity();
        coloreEntity.setEsadecimale(esadecimale);

        PaletteEntity paletteEntity=paletteRepository.findByIdPalette(idPalette);
        paletteEntity.setIdPalette(idPalette);
        coloreEntity.setPaletteEntity(paletteEntity);

        coloreRepository.save(coloreEntity);
        return coloreEntity;
    }

    @Override
    @Transactional
    public ColoreEntity get(int id) {
        ColoreEntity coloreEntity=coloreRepository.findById(id).orElse(null);
        return coloreEntity;
    }

    @Override
    @Transactional
    public ColoreEntity update(ColoreEntity newColoreEntity,int esadecimale,int idPalette) {
        ColoreEntity coloreEntity=coloreRepository.findById(esadecimale).orElse(null);

        newColoreEntity.setIdColore(esadecimale);

        newColoreEntity.getPaletteEntity().setIdPalette(idPalette);

        coloreEntity.setPaletteEntity(newColoreEntity.getPaletteEntity());
        ColoreEntity saved=coloreRepository.save(coloreEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(int esadecimale, int idPalette) {
        coloreRepository.deleteById(esadecimale);
    }
}
