package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Model.MappaModel;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappaServiceImpl implements MappaService{
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private MappaRepository mappaRepository;

    @Override
    @Transactional
    public MappaEntity add(String nome,int lunghezza,int larghezza,String email) {
        MappaEntity mappaEntity=new MappaEntity();
        mappaEntity.setNome(nome);
        mappaEntity.setLunghezza(lunghezza);
        mappaEntity.setLarghezza(larghezza);

        UtenteEntity utenteEntity=utenteRepository.findByEmail(email);
        utenteEntity.setEmail(email);
        mappaEntity.setIdMappaUtente(utenteEntity);

        mappaRepository.save(mappaEntity);
        return mappaEntity;
    }

    @Override
    @Transactional
    public MappaEntity get(String nome) {
        MappaEntity mappaEntity=mappaRepository.findByNome(nome).get();
        return mappaEntity;
    }

    @Override
    @Transactional
    public MappaEntity update(MappaEntity newMappaEntity, String nomeMappa) {
        MappaEntity mappaEntity=mappaRepository.findByNome(nomeMappa).get();
        newMappaEntity.setNome(nomeMappa);
        mappaEntity.setNome(newMappaEntity.getNome());
        mappaEntity.setLunghezza(newMappaEntity.getLunghezza());
        mappaEntity.setLarghezza(newMappaEntity.getLarghezza());
        MappaEntity saved=mappaRepository.save(mappaEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeMappa) {
        mappaRepository.deleteByNome(nomeMappa);
    }
}
