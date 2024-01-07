package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Exception.GEN.GEN.InvalidPropertyNameException;
import it.unisa.IS_Project.Exception.GEN.GEN.InvalidPropertyValueException;
import it.unisa.IS_Project.Exception.GEN.GEN.NotUniquePropertyException;
import it.unisa.IS_Project.Exception.GEN.GEN.PropertyNotFoundException;

import java.util.List;

public interface ProprietaService {
    void creaProprieta(String nomeProprieta, String valoreProprieta, EntitaEntity entita) throws InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException;

    void modificaProprieta(String nomeProprieta, String valoreProprieta, EntitaEntity entita) throws PropertyNotFoundException, InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException;

    List<ProprietaEntity> getLista(EntitaEntity entita);

    void save(ProprietaEntity proprieta);
}
