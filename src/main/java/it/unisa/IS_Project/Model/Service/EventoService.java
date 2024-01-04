package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EventoService {
    void creaEvento(String email, String nome, String riga, String colonna, List<String> nomiIstruzioni, List<String> valoriIstruzioni);

    @Transactional
    void creaEvento(String mappa, String email, String nome, String riga, String colonna, List<String> nomiIstruzioni, List<String> valoriIstruzioni);

    EventoEntity get(String nomeEvento);

    EventoEntity update(EventoEntity newEventoEntity, String nomeEvento);

    void delete(String nomeEvento);

    List<EventoEntity> getAllEvento(String email);
}
