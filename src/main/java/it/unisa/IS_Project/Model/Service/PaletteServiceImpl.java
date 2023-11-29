package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.PaletteModel;
import it.unisa.IS_Project.Model.Repository.PaletteRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaletteServiceImpl implements PaletteService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaletteRepository paletteRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public PaletteModel add(PaletteModel paletteModel) {
        PaletteEntity paletteEntity=modelMapper.map(paletteModel, PaletteEntity.class);
        paletteRepository.save(paletteEntity);
        return modelMapper.map(paletteEntity, PaletteModel.class);
    }

    @Override
    @Transactional
    public PaletteModel add2(PaletteModel paletteModel,String nomePalette,String email){
        PaletteEntity paletteEntity=modelMapper.map(paletteModel,PaletteEntity.class);
        paletteEntity.setNomePalette(nomePalette);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);

        paletteEntity.setEmailUtente(utenteEntity);

        paletteRepository.save(paletteEntity);
        return modelMapper.map(paletteEntity, PaletteModel.class);
    }

    @Override
    @Transactional
    public PaletteModel get(String nomePalette) {
        PaletteEntity paletteEntity=paletteRepository.findByNomePalette(nomePalette);
        return modelMapper.map(paletteEntity, PaletteModel.class);
    }

    @Override
    @Transactional
    public PaletteModel update(PaletteModel newPaletteModel, String nomePalette) {
        PaletteEntity paletteEntity=paletteRepository.findByNomePalette(nomePalette);
        newPaletteModel.setNomePalette(nomePalette);
        paletteEntity.setNomePalette(newPaletteModel.getNomePalette());
        PaletteEntity saved=paletteRepository.save(paletteEntity);
        return modelMapper.map(saved, PaletteModel.class);
    }

    @Override
    @Transactional
    public void delete(String nomePalette) {
        paletteRepository.deleteById(nomePalette);
    }
}
