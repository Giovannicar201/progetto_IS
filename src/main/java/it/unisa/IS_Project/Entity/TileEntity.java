package it.unisa.IS_Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tile")
public class TileEntity {
    @Id
    private int id;
    private String proprieta;
    private String collisione;

    @OneToMany(mappedBy = "tileEntity")
    private List<ComprendeEntity> idTileComprende;

    @OneToMany(mappedBy = "idIileEntity")
    private List<PiazzatoEntity> idTilePiazzato;
}
