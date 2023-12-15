package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Model.EventoModel;

public interface EventoService {
    EventoEntity add(String nomeEvento,String email);

    EventoEntity get(String nomeEvento);

    EventoEntity update(EventoEntity newEventoEntity, String nomeEvento);

    void delete(String nomeEvento);
}
