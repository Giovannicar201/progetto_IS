package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity,Integer> {
    @Query
    Optional<EventoEntity> findByNome(String nomeEvento);

    @Query
    void deleteByNome(String nomeEvento);
}
