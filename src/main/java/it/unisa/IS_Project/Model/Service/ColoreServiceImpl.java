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
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,idPalette);
        ColoreEntity coloreEntity=new ColoreEntity();
        primaryKey.setEsadecimale(esadecimale);
        primaryKey.setIdPalette(idPalette);
        coloreEntity.setPrimaryKey(primaryKey);

        PaletteEntity paletteEntity=paletteRepository.findByIdPalette(idPalette);
        paletteEntity.setIdPalette(idPalette);
        coloreEntity.setNomePaletteEntity(paletteEntity);

        coloreRepository.save(coloreEntity);
        return coloreEntity;
    }

    @Override
    @Transactional
    public ColoreEntity get(String esadecimale, int idPalette) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,idPalette);
        ColoreEntity coloreEntity=coloreRepository.findById(primaryKey).orElse(null);
        return coloreEntity;
    }

    @Override
    @Transactional
    public ColoreEntity update(ColoreEntity newColoreEntity,String esadecimale,int idPalette) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,idPalette);
        ColoreEntity coloreEntity=coloreRepository.findById(primaryKey).orElse(null);

        newColoreEntity.setPrimaryKey(coloreEntity.getPrimaryKey());

        newColoreEntity.getNomePaletteEntity().setIdPalette(idPalette);

        coloreEntity.setNomePaletteEntity(newColoreEntity.getNomePaletteEntity());
        ColoreEntity saved=coloreRepository.save(coloreEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String esadecimale, int idPalette) {
        ColoreEntity.PrimaryKey primaryKey=new ColoreEntity.PrimaryKey(esadecimale,idPalette);
        coloreRepository.deleteById(primaryKey);
    }
}
