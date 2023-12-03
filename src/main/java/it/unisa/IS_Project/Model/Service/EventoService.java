package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Model.EventoModel;

public interface EventoService {
    EventoModel add(EventoModel eventoModel);

    EventoModel add2(EventoModel eventoModel,int idEvento,int idMappa);

    EventoModel get(int idEvento,int idMappa);

    EventoModel update(EventoModel newEventoModel,int idEvento,int idMappa);

    void delete(int idEvento,int idMappa);
}
