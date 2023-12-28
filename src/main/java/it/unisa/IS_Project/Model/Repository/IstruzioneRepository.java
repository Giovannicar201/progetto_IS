package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import it.unisa.IS_Project.Model.Entity.PrimaryKeyIstruzione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IstruzioneRepository extends JpaRepository<IstruzioneEntity, Integer> {
    @Query("SELECT i FROM IstruzioneEntity i WHERE i.nome = :nome AND i.eventoEntity.nome = :nomeEvento")
    Optional<IstruzioneEntity> findByNomeAndNomeEvento(@Param("nome")String nome,@Param("nomeEvento")String nomeEvento);

    @Query
    Optional<IstruzioneEntity> findByNome(String nome);

    @Query("DELETE FROM IstruzioneEntity i WHERE i.nome = :nome AND i.eventoEntity.idEvento = :idEvento")
    void deleteByNomeAndIdEvento(String nome,int idEvento);

    @Query("SELECT i FROM IstruzioneEntity i WHERE i.eventoEntity.nome = :nomeEvento")
    List<IstruzioneEntity> getAllByNomeEvento(@Param("nomeEvento")String nomeEvento);
}
