package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Model.EventoModel;
import it.unisa.IS_Project.Model.Model.MappaModel;
import it.unisa.IS_Project.Model.Repository.EventoRepository;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public EventoModel add(EventoModel eventoModel) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(eventoModel.getIdEvento(),eventoModel.getIdMappaEvento().getId());
        EventoEntity eventoEntity=modelMapper.map(eventoModel,EventoEntity.class);
        eventoEntity.setPrimaryKey(primaryKey);
        eventoRepository.save(eventoEntity);
        return modelMapper.map(eventoEntity, EventoModel.class);
    }

    @Override
    @Transactional
    public EventoModel add2(EventoModel eventoModel,int idEvento,int idMappa) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(idEvento,idMappa);
        EventoEntity eventoEntity=modelMapper.map(eventoModel,EventoEntity.class);
        primaryKey.setIdEvento(idEvento);
        primaryKey.setIdMappa(idMappa);
        eventoEntity.setPrimaryKey(primaryKey);

        MappaEntity mappaEntity=mappaRepository.findById(idMappa).get();
        mappaEntity.setId(idMappa);

        eventoEntity.setIdMappaEvento(mappaEntity);
        eventoEntity.setNome(eventoEntity.getNome());

        eventoRepository.save(eventoEntity);
        return modelMapper.map(eventoEntity, EventoModel.class);
    }

    @Override
    @Transactional
    public EventoModel get(int idEvento, int idMappa) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(idEvento,idMappa);
        EventoEntity eventoEntity=eventoRepository.findById(primaryKey).orElse(null);
        return modelMapper.map(eventoEntity, EventoModel.class);
    }

    @Override
    @Transactional
    public EventoModel update(EventoModel newEventoModel, int idEvento, int idMappa) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(idEvento,idMappa);
        EventoEntity eventoEntity=eventoRepository.findById(primaryKey).orElse(null);

        newEventoModel.setIdEvento(idEvento);

        newEventoModel.getIdMappaEvento().setId(idMappa);

        eventoEntity.setNome(newEventoModel.getNome());
        EventoEntity saved=eventoRepository.save(eventoEntity);

        return modelMapper.map(saved, EventoModel.class);
    }

    @Override
    @Transactional
    public void delete(int idEvento, int idMappa) {
        EventoEntity.PrimaryKey primaryKey=new EventoEntity.PrimaryKey(idEvento,idMappa);
        eventoRepository.deleteById(primaryKey);
    }
}
