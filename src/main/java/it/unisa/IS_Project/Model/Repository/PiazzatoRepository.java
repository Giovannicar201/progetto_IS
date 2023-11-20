package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.PiazzatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiazzatoRepository extends JpaRepository<PiazzatoEntity,PiazzatoEntity.PrimaryKey> {
}
