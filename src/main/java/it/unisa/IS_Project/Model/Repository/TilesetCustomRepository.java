package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.TilesetCustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TilesetCustomRepository extends JpaRepository<TilesetCustomEntity,Integer> {
    @Query
    Optional<TilesetCustomEntity> findAllById(int idTilesetCustom);
}
