package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartellaRepository extends JpaRepository<CartellaEntity,Integer> {
    @Query
    Optional<CartellaEntity> findAllById(int idCartella);

    @Query("SELECT c FROM CartellaEntity c WHERE c.utenteEntity.email = :email")
    Optional<CartellaEntity> findAllByEmail(@Param("email")String email);

    @Query("SELECT c FROM CartellaEntity c WHERE c.utenteEntity.email = :email AND c.nome = :nome")
    Optional<CartellaEntity> findAllByEmailAndNome(@Param("email")String email,@Param("nome") String nomeCartella);

    @Query
    Optional<CartellaEntity> findByNome(String nomeCartella);

    @Query
    void deleteByNome(String nomeCartella);
}
