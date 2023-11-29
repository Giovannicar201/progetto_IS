package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartellaRepository extends JpaRepository<CartellaEntity,Integer> {
    @Query
    Optional<CartellaEntity> findAllById(int idCartella);
}
