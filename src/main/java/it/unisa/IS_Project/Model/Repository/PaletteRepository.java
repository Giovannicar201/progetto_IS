package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.PaletteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaletteRepository extends JpaRepository<PaletteEntity,Integer> {
    @Query
    PaletteEntity findByIdPalette(int idPalette);

    @Query
    Optional<PaletteEntity> findByNomePalette(String nomePalette);

    @Query
    void deleteByNomePalette(String nomePalette);

    @Query("SELECT p FROM PaletteEntity p WHERE p.emailUtente.email = :email")
    List<PaletteEntity> getAllByEmail(String email);
}
