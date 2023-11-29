package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.PaletteModel;

public interface PaletteService {
    PaletteModel add(PaletteModel paletteModel);

    PaletteModel add2(PaletteModel paletteModel,String nomePalette,String email);

    PaletteModel get(String nomePalette);

    PaletteModel update(PaletteModel newPaletteModel,String nomePalette);

    void delete(String nomePalette);
}
