package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntitaRepository extends JpaRepository<EntitaEntity,Integer> {
    @Query
    Optional<EntitaEntity> findAllById(int idEntita);

    @Query
    EntitaEntity findByNome(String nomeEntita);

    @Query("SELECT e FROM EntitaEntity e WHERE e.cartellaEntity.nome = :nomeCartella AND e.email.email = :email")
    List<EntitaEntity> findAllByCartellaEntity(@Param("email")String email, @Param("nomeCartella")String nomeCartella);

    @Query("SELECT e FROM EventoEntity e WHERE e.utenteEntity.email = :email")
    List<EntitaEntity> findAllByEmail(String email);
}
