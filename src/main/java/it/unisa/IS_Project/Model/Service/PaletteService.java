package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;

public interface PaletteService {
    PaletteEntity add(String nomePalette,String email);

    PaletteEntity get(String nomePalette);

    PaletteEntity update(PaletteEntity newPaletteEntity, String nomePalette);

    void delete(String nomePalette);
}
