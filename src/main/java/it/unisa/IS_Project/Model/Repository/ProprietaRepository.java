package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietaRepository extends JpaRepository<ProprietaEntity,Integer> {
    @Query
    ProprietaEntity findByNome(String nomeProprieta);

    @Query("SELECT p FROM ProprietaEntity p WHERE p.entitaEntity = :entita")
    List<ProprietaEntity> findAllByEntita(EntitaEntity entita);
}
