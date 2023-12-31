package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImmagineRepository extends JpaRepository<ImmagineEntity,Integer> {
    @Query
    ImmagineEntity findById(int id);

    @Query
    List<ImmagineEntity> findAllByUtenteEntity(UtenteEntity utenteEntity);

    @Query
    ImmagineEntity findByNomeAndUtenteEntity(String nome, UtenteEntity utenteEntity);
}
