package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.*;
import it.unisa.IS_Project.Model.Repository.EventoRepository;
import it.unisa.IS_Project.Utility.Validator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private MappaService mappaService;

    @Override
    public void creaEvento(String email, String nome, String riga, String colonna, List<String> nomiIstruzioni, List<String> valoriIstruzioni) {

    }

    @Override
    @Transactional
    public void creaEvento(String mappa, String email, String nome, String riga, String colonna,
                           List<String> nomiIstruzioni, List<String> valoriIstruzioni) {
       /* EventoEntity eventoEntity = new EventoEntity();
        EventoEntity eventoEntityQuery = eventoRepository.findByNome(nome);
        EventoEntity entitaEntitySecondQuery = eventoRepository.findByRigaAndColonna(riga,colonna);
        UtenteEntity utenteEntity = utenteService.get(email);

        if(!Validator.isEventNameValid(nome))
            throw new InvalidEventNameException("ERRORE - NOME NON VALIDO.");

        if(eventoEntityQuery != null)
            throw new NotUniqueEventException("ERRORE - EVENTO GIÀ ESISTENTE.");

        if(!Validator.isNumberOfIstructionsValid(nomiIstruzioni.size()))
            throw new InvalidNumberOfIstructionsException("ERRORE - NUMERO DI ISTRUZIONI NON VALIDO.");

        eventoEntity.setUtenteEntity(utenteEntity); //sarebbe un set email, da cambiare in entity
        eventoEntity.setIdMappaEvento(mappa); //da vedere cosa viene messo in sessione
        eventoEntity.setNome(nome);
        eventoEntity.setRiga(riga);
        eventoEntity.setColonna(colonna);

        Iterator<String> iteratoreNomi = nomiIstruzioni.iterator();
        Iterator<String> iteratoreValori = valoriIstruzioni.iterator();

        while (iteratoreNomi.hasNext() && iteratoreValori.hasNext()) {
            String nomeIstruzione = iteratoreNomi.next();
            String valoreIstruzione = iteratoreValori.next();

            IstruzioneEntity istruzioneEntity = new IstruzioneEntity();

            istruzioneEntity.setNome(nomeIstruzione);
            istruzioneEntity.setValore(valoreIstruzione);
            istruzioneEntity.setEventoEntity(eventoEntity);
        }*/

        eventoRepository.save(null);
    }

    @Override
    @Transactional
    public EventoEntity get(String nomeEvento) {
       // EventoEntity eventoEntity=eventoRepository.findByNome(nomeEvento).orElse(null);
        return null;
    }

    @Override
    @Transactional
    public EventoEntity update(EventoEntity newEventoEntity,String nomeEvento) {
       // EventoEntity eventoEntity=eventoRepository.findByNome(nomeEvento).orElse(null);

        newEventoEntity.setNome(nomeEvento);


       // eventoEntity.setNome(newEventoEntity.getNome());
        //EventoEntity saved=eventoRepository.save(eventoEntity);

        return null;
    }

    @Override
    @Transactional
    public void delete(String nomeEvento) {
        eventoRepository.deleteByNome(nomeEvento);
    }

    @Override
    @Transactional
    public List<EventoEntity> getAllEvento(String email){
        return eventoRepository.findAllByEmail(email);
    }
}
