package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartellaRepository extends JpaRepository<CartellaEntity,Integer> {
    @Query
    CartellaEntity findByNomeAndUtenteEntity(String nome, UtenteEntity utente);

    @Query
    List<CartellaEntity> findAllByUtenteEntity(UtenteEntity utenteEntity);

    @Query
    CartellaEntity findById(int id);

    @Query
    CartellaEntity findByNome(String nome);
}
