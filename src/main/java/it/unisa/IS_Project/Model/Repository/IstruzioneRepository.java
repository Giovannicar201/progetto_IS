package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstruzioneRepository extends JpaRepository<IstruzioneEntity,IstruzioneEntity.PrimaryKey> {
}
