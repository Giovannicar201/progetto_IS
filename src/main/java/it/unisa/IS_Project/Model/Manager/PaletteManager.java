package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import it.unisa.IS_Project.Model.Model.PaletteModel;

public interface PaletteManager {
    PaletteEntity save(PaletteModel paletteModel);

    PaletteEntity get(String nomePalette);

    void delete(String nomePalette);
}
