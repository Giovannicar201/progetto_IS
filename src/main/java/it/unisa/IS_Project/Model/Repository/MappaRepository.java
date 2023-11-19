package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.MappaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MappaRepository extends JpaRepository<MappaEntity,Integer> {
    @Query
    Optional<MappaEntity> findById(int idMappa);
}
