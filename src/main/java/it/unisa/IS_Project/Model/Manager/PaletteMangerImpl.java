package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import it.unisa.IS_Project.Model.Model.PaletteModel;
import it.unisa.IS_Project.Model.Repository.PaletteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaletteMangerImpl implements PaletteManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaletteRepository paletteRepository;

    @Override
    public PaletteEntity save(PaletteModel paletteModel) {
        PaletteEntity paletteEntity=modelMapper.map(paletteModel,PaletteEntity.class);
        return paletteRepository.save(paletteEntity);
    }

    @Override
    public PaletteEntity get(String nomePalette) {
        return paletteRepository.findByNomePalette(nomePalette).orElseThrow(()->new RuntimeException("Palette non trovata"));
    }

    @Override
    public void delete(String nomePalette) {
        if(paletteRepository.existsById(nomePalette)){
            paletteRepository.deleteById(nomePalette);
        }
    }
}
