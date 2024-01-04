package it.unisa.IS_Project.Model.Repository;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImmagineRepository extends JpaRepository<ImmagineEntity,Integer> {
    @Query
    Optional<ImmagineEntity> findAllByIdFoto(int idFoto);

    @Query("SELECT i FROM ImmagineEntity i WHERE i.utenteEntity.email = :email")
    List<ImmagineEntity> findAllByEmail(@Param("email")String email);

    @Query("SELECT i FROM ImmagineEntity i WHERE i.nome = :nome")
    ImmagineEntity findByNome(@Param("nome") String nome);

    @Query("SELECT i FROM ImmagineEntity i,UtenteEntity u WHERE i.utenteEntity.email=u.email AND i.utenteEntity.email = :email AND i.nome = :nome")
    ImmagineEntity findByNomeAndEmail(@Param("nome")String nome,@Param("email")String email);

    @Query
    void deleteByNome(String nomeFoto);
}
