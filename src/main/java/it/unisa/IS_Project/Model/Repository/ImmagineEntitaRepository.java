package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ImmagineEntitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmagineEntitaRepository extends JpaRepository<ImmagineEntitaEntity,String> {
}
