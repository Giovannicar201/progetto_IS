package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProprietaRepository extends JpaRepository<ProprietaEntity,Integer> {
    Optional<ProprietaEntity> findByIdProprieta(int idProprieta);

    @Query
    Optional<ProprietaEntity> findByNome(String nomeProprieta);

    @Query
    Optional<ProprietaEntity> deleteByNome(String nomeProprieta);
}
