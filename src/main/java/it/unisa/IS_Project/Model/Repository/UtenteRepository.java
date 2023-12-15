package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Entity.MappaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity,String> {
    @Query
    Optional<UtenteEntity> findAllByEmail(String email);

    @Query("SELECT u FROM UtenteEntity u WHERE u.email = :email")
    UtenteEntity findByEmail(String email);
}
