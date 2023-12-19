package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import it.unisa.IS_Project.Model.Entity.PrimaryKeyIstruzione;
import it.unisa.IS_Project.Model.Repository.EventoRepository;
import it.unisa.IS_Project.Model.Repository.IstruzioneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IstruzioneServiceImpl implements IstruzioneService{
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private IstruzioneRepository istruzioneRepository;

    @Override
    @Transactional
    public IstruzioneEntity add(int idIstruzione,String nomeIstruzione,String valore,int idEvento) {
        IstruzioneEntity istruzioneEntity=new IstruzioneEntity();
        istruzioneEntity.setIdIstruzione(idIstruzione);
        istruzioneEntity.setIdEvento(idEvento);

        istruzioneEntity.setNome(nomeIstruzione);
        istruzioneEntity.setValore(valore);

        EventoEntity eventoEntity=eventoRepository.findById(idEvento).get();
        eventoEntity.setIdEvento(idEvento);
        istruzioneEntity.setEventoEntity(eventoEntity);

        istruzioneRepository.save(istruzioneEntity);
        return istruzioneEntity;
    }

    @Override
    public IstruzioneEntity get(int idIstruzione, int idEvento) {
        return null;
    }

    @Override
    public IstruzioneEntity update(IstruzioneEntity newIstruzioneEntity, int idIstruzione, int idEvento) {
        return null;
    }

    @Override
    public void delete(int idIstruzione, int idEvento) {

    }

    /*@Override
    @Transactional
    public IstruzioneEntity get(int idIstruzione, int idEvento) {
        IstruzioneEntity istruzioneEntity=istruzioneRepository.findById(idIstruzione,idEvento).get();
        return istruzioneEntity;
    }

    @Override
    @Transactional
    public IstruzioneEntity update(IstruzioneEntity newIstruzioneEntity, int idIstruzione, int idEvento) {
        PrimaryKeyIstruzione primaryKey=new PrimaryKeyIstruzione(idIstruzione,idEvento);
        IstruzioneEntity istruzioneEntity=istruzioneRepository.findById(primaryKey).get();

        newIstruzioneEntity.setIdIstruzione(idIstruzione);
        newIstruzioneEntity.setIdEvento(idEvento);

        istruzioneEntity.setNome(newIstruzioneEntity.getNome());
        istruzioneEntity.setValore(newIstruzioneEntity.getValore());

        IstruzioneEntity saved=istruzioneRepository.save(istruzioneEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(int idIstruzione, int idEvento) {
        PrimaryKeyIstruzione primaryKey=new PrimaryKeyIstruzione(idIstruzione,idEvento);
        istruzioneRepository.deleteById(primaryKey);
    }*/
}
