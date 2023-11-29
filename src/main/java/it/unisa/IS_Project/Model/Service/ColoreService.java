package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.ColoreModel;

public interface ColoreService {
    ColoreModel add(ColoreModel coloreModel);

    ColoreModel add2(ColoreModel coloreModel,String esadecimale,String nomePalette);
    
    ColoreModel get(String esadecimale,String nomePalette);
    
    ColoreModel update(ColoreModel newColoreModel,String esadecimale,String nomePalette);
    
    void delete(String esadecimale,String nomePalette);
}
