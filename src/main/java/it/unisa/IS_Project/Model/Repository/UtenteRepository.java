package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity,String> {
    @Query
    Optional<UtenteEntity> findAllByUsername(String username);
}
