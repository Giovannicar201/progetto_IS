package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaletteRepository extends JpaRepository<PaletteEntity,String> {
    @Query
    PaletteEntity findByNomePalette(String nomePalette);
}
