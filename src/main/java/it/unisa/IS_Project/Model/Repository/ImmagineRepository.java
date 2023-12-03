package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImmagineRepository extends JpaRepository<ImmagineEntity,Integer> {
    @Query
    Optional<ImmagineEntity> findAllByIdFoto(int idFoto);
}
