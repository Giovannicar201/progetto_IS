package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EntitaRepository extends JpaRepository<EntitaEntity,Integer> {
    @Query
    EntitaEntity findById(int id);

    @Query
    EntitaEntity findByNomeAndUtenteEntity(String nome, UtenteEntity utenteEntity);

    @Query
    List<EntitaEntity> findAllByCartellaEntityAndUtenteEntity(CartellaEntity cartellaEntity, UtenteEntity utenteEntity);

    @Query
    List<EntitaEntity> findAllByUtenteEntity(UtenteEntity utenteEntity);

    @Query
    EntitaEntity findByImmagineEntity(ImmagineEntity immagineEntity);
}
