package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.CoordinateEntity;
import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Repository.CoordinateRepository;
import it.unisa.IS_Project.Model.Repository.EntitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImpl implements CoordinateService{
    @Autowired
    private CoordinateRepository coordinateRepository;
    @Autowired
    private EntitaRepository entitaRepository;

    @Override
    public CoordinateEntity aggiuntaCoordinate(String coordinataX, String coordinataY, String nomeEntita) {
        EntitaEntity entitaEntity=entitaRepository.findByNome(nomeEntita);
        CoordinateEntity.PrimaryKeyCoordinate primaryKeyCoordinate=new CoordinateEntity.PrimaryKeyCoordinate(coordinataX,coordinataY,entitaEntity.getId());
        CoordinateEntity coordinateEntity=new CoordinateEntity();

        primaryKeyCoordinate.setCoordinataX(coordinataX);
        primaryKeyCoordinate.setCoordinataY(coordinataY);
        primaryKeyCoordinate.setIdEvento(entitaEntity.getId());
        coordinateEntity.setPrimaryKeyCoordinate(primaryKeyCoordinate);

        coordinateRepository.save(coordinateEntity);
        return coordinateEntity;
    }
}
