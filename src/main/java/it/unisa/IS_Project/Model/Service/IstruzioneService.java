package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;

import java.util.List;

public interface IstruzioneService {
    IstruzioneEntity add(String nomeIstruzione,String valore,String nomeEvento);

    IstruzioneEntity get(String nomeIstruzione);

    IstruzioneEntity update(IstruzioneEntity newIstruzioneEntity,String nomeIstruzione);

    void delete(String nomeIstruzione,String nomeEvento);

    List<IstruzioneEntity> getAllEntityFromNomeEvento(String nomeEvento);
}
