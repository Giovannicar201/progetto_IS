package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;

public interface ColoreService {
    ColoreEntity add(String esadecimale,int idPalette);

    ColoreEntity get(int id);
    
    ColoreEntity update(ColoreEntity newColoreEntity,int esadecimale,int idPalette);
    
    void delete(int esadecimale,int idPalette);
}
