package it.unisa.IS_Project.Model.Manager;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Model.EventoModel;
import it.unisa.IS_Project.Model.Repository.EventoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoManagerImpl implements EventoManager{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public EventoEntity save(EventoModel eventoModel) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(eventoModel.getIdMappaEvento().getId(),eventoModel.getIdEvento());
        EventoEntity eventoEntity=modelMapper.map(eventoModel,EventoEntity.class);
        eventoEntity.setPrimaryKey(primaryKey);
        return eventoRepository.save(eventoEntity);
    }

    @Override
    public EventoEntity get(int idEvento, int idMappa) {
        return eventoRepository.findById(new EventoEntity.PrimaryKey(idMappa,idEvento)).orElseThrow(()->new RuntimeException("Evento non trovato"));
    }

    @Override
    public void delete(int idEvento, int idMappa) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(idMappa,idEvento);
        if (eventoRepository.existsById(primaryKey)){
            eventoRepository.deleteById(primaryKey);
        }
    }
}
