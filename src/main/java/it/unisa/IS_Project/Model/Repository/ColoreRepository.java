package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.ColoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoreRepository extends JpaRepository<ColoreEntity,String> {
}
