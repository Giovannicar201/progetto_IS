package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.UtenteModel;

public interface UtenteService {
    UtenteModel add(UtenteModel utenteModel);

    UtenteModel get(String email);

    UtenteModel update(UtenteModel newUtenteModel,String email);

    UtenteModel updateIdMappa(UtenteModel newUtenteModel,String email,int idMappa);

    void delete(String email);
}
