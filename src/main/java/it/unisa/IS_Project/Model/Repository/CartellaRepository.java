package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartellaRepository extends JpaRepository<CartellaEntity,Integer> {
    @Query("SELECT c FROM CartellaEntity c WHERE c.utenteEntity.email = :email")
    List<CartellaEntity> findAllByEmail(@Param("email")String email);
    @Query
    CartellaEntity findByNome(String nomeCartella);
}
