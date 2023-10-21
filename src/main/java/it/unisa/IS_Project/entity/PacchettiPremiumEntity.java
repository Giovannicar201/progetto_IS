package it.unisa.IS_Project.entity;

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
@Table(name = "pacchettiPremium")
public class PacchettiPremiumEntity {
    @Id
    @Column(name = "idPacchettiPremium")
    private int id;
    private String nome;
    private double prezzo;

    @OneToMany(mappedBy = "idPacchettiPremium")
    private List<CompraEntity> pacchettiPremiumList;
}
