package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ProprietaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaRepository extends JpaRepository<ProprietaEntity,String> {
}
