package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.EventoRepository;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public EventoEntity add(String nomeEvento,String email) {
        EventoEntity eventoEntity=new EventoEntity();
        eventoEntity.setNome(nomeEvento);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);
        //eventoEntity.setIdEvento(utenteEntity);

        MappaEntity mappaEntity=mappaRepository.findAllByEmail(email);
        eventoEntity.setIdMappaEvento(mappaEntity);

        eventoRepository.save(eventoEntity);
        return eventoEntity;
    }

    @Override
    @Transactional
    public EventoEntity get(String nomeEvento) {
        EventoEntity eventoEntity=eventoRepository.findByNome(nomeEvento).orElse(null);
        return eventoEntity;
    }

    @Override
    @Transactional
    public EventoEntity update(EventoEntity newEventoEntity,String nomeEvento) {
        EventoEntity eventoEntity=eventoRepository.findByNome(nomeEvento).orElse(null);

        newEventoEntity.setNome(nomeEvento);


        eventoEntity.setNome(newEventoEntity.getNome());
        EventoEntity saved=eventoRepository.save(eventoEntity);

        return saved;
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
