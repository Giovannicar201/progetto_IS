package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColoreRepository extends JpaRepository<ColoreEntity,String> {
    @Query
    Optional<ColoreEntity> findColoreEntityByEsadecimale(String esadecimale);
}