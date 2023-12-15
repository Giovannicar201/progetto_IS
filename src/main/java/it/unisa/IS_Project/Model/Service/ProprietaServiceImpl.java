package it.unisa.IS_Project.Model.Service;


import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import it.unisa.IS_Project.Model.Model.ProprietaModel;
import it.unisa.IS_Project.Model.Repository.EntitaRepository;
import it.unisa.IS_Project.Model.Repository.ProprietaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietaServiceImpl implements ProprietaService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProprietaRepository proprietaRepository;
    @Autowired
    private EntitaRepository entitaRepository;

    @Override
    @Transactional
    public ProprietaEntity add(String nomeProprieta,String valore,int idEntita) {
        ProprietaEntity proprietaEntity=new ProprietaEntity();
        proprietaEntity.setNome(nomeProprieta);
        proprietaEntity.setValore(valore);

        EntitaEntity entitaEntity=entitaRepository.findAllById(idEntita).get();
        entitaEntity.setId(idEntita);

        proprietaEntity.setEntita(entitaEntity);

        proprietaRepository.save(proprietaEntity);
        return proprietaEntity;
    }

    @Override
    @Transactional
    public ProprietaEntity get(String nomeProprieta) {
        ProprietaEntity proprietaEntity=proprietaRepository.findByNome(nomeProprieta).get();
        return proprietaEntity;
    }

    @Override
    @Transactional
    public ProprietaEntity update(ProprietaEntity newProprietaEntity,String nomeProprieta) {
        ProprietaEntity proprietaEntity=proprietaRepository.findByNome(nomeProprieta).orElse(null);
        newProprietaEntity.setNome(nomeProprieta);
        proprietaEntity.setNome(newProprietaEntity.getNome());
        ProprietaEntity saved=proprietaRepository.save(proprietaEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeProprieta) {
        proprietaRepository.deleteByNome(nomeProprieta);
    }
}
