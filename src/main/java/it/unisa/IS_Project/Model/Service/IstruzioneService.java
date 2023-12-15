package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import it.unisa.IS_Project.Model.Model.IstruzioneModel;

public interface IstruzioneService {
    IstruzioneEntity add(int idIstruzione,String nomeIstruzione,String valore,int idEvento);

    IstruzioneEntity get(int idIstruzione, int idEvento);

    IstruzioneEntity update(IstruzioneEntity newIstruzioneEntity, int idIstruzione, int idEvento);

    void delete(int idIstruzione,int idEvento);
}
