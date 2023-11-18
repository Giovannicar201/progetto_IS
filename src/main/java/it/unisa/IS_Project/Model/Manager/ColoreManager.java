package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;
import it.unisa.IS_Project.Model.Model.ColoreModel;

public interface ColoreManager {
    ColoreEntity save(ColoreModel coloreModel);

    ColoreEntity get(String esadecimale);

    void delete(String esadecimale);
}
