package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;

public interface ColoreService {
    ColoreEntity add(String esadecimale,int idPalette);

    ColoreEntity get(String esadecimale,int idPalette);
    
    ColoreEntity update(ColoreEntity newColoreEntity,String esadecimale,int idPalette);
    
    void delete(String esadecimale,int idPalette);
}
