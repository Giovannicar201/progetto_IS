package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;

import java.util.List;

public interface PaletteService {
    PaletteEntity add(String nomePalette,String email);

    PaletteEntity get(String nomePalette);

    PaletteEntity update(PaletteEntity newPaletteEntity, String nomePalette);

    void delete(String nomePalette);

    List<PaletteEntity> getAllPalette(String email);
}
