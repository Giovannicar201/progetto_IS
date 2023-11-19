package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Model.EventoModel;

public interface EventoManager {
    EventoEntity save(EventoModel eventoModel);

    EventoEntity get(int idEvento,int idMappa);

    void delete(int idEvento,int idMappa);
}
