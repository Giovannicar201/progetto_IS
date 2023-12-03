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
    public ProprietaModel add(ProprietaModel proprietaModel) {
        ProprietaEntity proprietaEntity=modelMapper.map(proprietaModel,ProprietaEntity.class);
        proprietaRepository.save(proprietaEntity);
        return modelMapper.map(proprietaEntity,ProprietaModel.class);
    }

    @Override
    @Transactional
    public ProprietaModel add2(ProprietaModel proprietaModel, int idProprieta, int idEntita) {
        ProprietaEntity proprietaEntity=modelMapper.map(proprietaModel,ProprietaEntity.class);
        proprietaEntity.setIdProprieta(idProprieta);

        EntitaEntity entitaEntity=entitaRepository.findAllById(idEntita).get();
        entitaEntity.setId(idEntita);

        proprietaEntity.setEntita(entitaEntity);

        proprietaRepository.save(proprietaEntity);
        return modelMapper.map(proprietaEntity,ProprietaModel.class);
    }

    @Override
    @Transactional
    public ProprietaModel get(int idProprieta) {
        ProprietaEntity proprietaEntity=proprietaRepository.findByIdProprieta(idProprieta).get();
        return modelMapper.map(proprietaEntity,ProprietaModel.class);
    }

    @Override
    @Transactional
    public ProprietaModel update(ProprietaModel newProprietaModel,int idProprieta) {
        ProprietaEntity proprietaEntity=proprietaRepository.findByIdProprieta(idProprieta).orElse(null);
        newProprietaModel.setIdProprieta(idProprieta);
        proprietaEntity.setNome(newProprietaModel.getNome());
        ProprietaEntity saved=proprietaRepository.save(proprietaEntity);
        return modelMapper.map(saved,ProprietaModel.class);
    }

    @Override
    @Transactional
    public void delete(int idProprieta) {
        proprietaRepository.deleteById(idProprieta);
    }
}
