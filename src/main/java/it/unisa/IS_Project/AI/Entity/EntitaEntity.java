package it.unisa.IS_Project.AI.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntitaEntity {

    private int id;
    private int numeroTotaleSullaMappa;
    private float numeroTotaleSullaMappaPercentuale;
    private int numeroTotaleSullaSelezione;
    private int daPiazzareSullaSelezione;
    private it.unisa.IS_Project.AI.Enum.LOD LOD;

    @Override
    public String toString() {

        return "@entita " +
                "@id::" + id +
                "@numeroTotaleSullaMappa::" + numeroTotaleSullaMappa + " " +
                "@numeroTotaleSullaMappaPercentuale::" + numeroTotaleSullaMappaPercentuale + " " +
                "@numeroTotaleSullaSelezione::" + numeroTotaleSullaSelezione + " " +
                "@daPiazzareSullaSelezione::" + daPiazzareSullaSelezione + " " +
                "@LOD::" + LOD;
    }

    @Override
    public EntitaEntity clone() {

        EntitaEntity clone = new EntitaEntity();

        clone.setId(this.id);
        clone.setNumeroTotaleSullaMappa(numeroTotaleSullaMappa);
        clone.setNumeroTotaleSullaMappaPercentuale(numeroTotaleSullaMappaPercentuale);
        clone.setNumeroTotaleSullaSelezione(numeroTotaleSullaSelezione);
        clone.setDaPiazzareSullaSelezione(daPiazzareSullaSelezione);
        clone.setLOD(this.LOD);

        return clone;
    }
}
