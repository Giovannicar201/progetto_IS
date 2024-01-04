package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<CoordinateEntity, CoordinateEntity.PrimaryKeyCoordinate> {
}
