package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import it.unisa.IS_Project.Model.Entity.PrimaryKeyIstruzione;
import it.unisa.IS_Project.Model.Repository.EventoRepository;
import it.unisa.IS_Project.Model.Repository.IstruzioneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IstruzioneServiceImpl implements IstruzioneService{
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private IstruzioneRepository istruzioneRepository;

    @Override
    @Transactional
    public IstruzioneEntity add(String nomeIstruzione,String valore,String nomeEvento) {
        IstruzioneEntity istruzioneEntity=new IstruzioneEntity();

        istruzioneEntity.setNome(nomeIstruzione);
        istruzioneEntity.setValore(valore);

        EventoEntity eventoEntity=eventoRepository.findByNome(nomeEvento);
        eventoEntity.setIdEvento(eventoEntity.getIdEvento());
        eventoEntity.setNome(nomeEvento);
        istruzioneEntity.setEventoEntity(eventoEntity);

        istruzioneRepository.save(istruzioneEntity);
        return istruzioneEntity;
    }

    @Override
    @Transactional
    public IstruzioneEntity get(String nomeIstruzione) {
        IstruzioneEntity istruzioneEntity=istruzioneRepository.findByNome(nomeIstruzione).get();
        return istruzioneEntity;
    }

    @Override
    @Transactional
    public IstruzioneEntity update(IstruzioneEntity newIstruzioneEntity,String nomeIstruzione) {
        IstruzioneEntity istruzioneEntity=istruzioneRepository.findByNome(nomeIstruzione).get();

        newIstruzioneEntity.setIdIstruzione(istruzioneEntity.getIdIstruzione());

        istruzioneEntity.setNome(newIstruzioneEntity.getNome());
        istruzioneEntity.setValore(newIstruzioneEntity.getValore());

        IstruzioneEntity saved=istruzioneRepository.save(istruzioneEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeIstruzione, String nomeEvento) {
        EventoEntity eventoEntity=eventoRepository.findByNome(nomeEvento);

        istruzioneRepository.deleteByNomeAndIdEvento(nomeIstruzione,eventoEntity.getIdEvento());
    }

    @Override
    @Transactional
    public List<IstruzioneEntity> getAllEntityFromNomeEvento(String nomeEvento){
        return istruzioneRepository.getAllByNomeEvento(nomeEvento);
    }

}
