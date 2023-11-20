package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity,CompraEntity.PrimaryKey> {
}
