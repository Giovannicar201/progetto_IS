package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.InvalidPropertyNameException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.InvalidPropertyValueException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.NotUniquePropertyException;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.CreazioneEntita.PropertyNotFoundException;

public interface ProprietaService {
    void creaProprieta(String nomeProprieta, String valoreProprieta, EntitaEntity entita) throws InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException;

    void modificaProprieta(String nomeProprieta, String valoreProprieta, EntitaEntity entita) throws PropertyNotFoundException, InvalidPropertyNameException, InvalidPropertyValueException, NotUniquePropertyException;
}
