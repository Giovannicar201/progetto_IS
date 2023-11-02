package it.unisa.IS_Project.Model.Entity;

import jakarta.persistence.*;
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
@Table(name = "pacchettiCustom")
public class PacchettiCustomEntity {
    @Id
    @Column(name = "idPacchettiCustom")
    private int id;
    private String nome;

    @OneToMany(mappedBy = "pacchettiCustomEntity")
    private List<ComprendeEntity> idPacchettiCustomComprende;

    @OneToMany(mappedBy = "pacchettiCustom")
    private List<CreaEntity> idPacchettiCustomCrea;
}
