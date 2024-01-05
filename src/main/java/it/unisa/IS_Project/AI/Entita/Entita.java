package it.unisa.IS_Project.AI.Entita;

public class Entita {
    private int id;
    private int numeroTotaleSullaMappa;
    private float numeroTotaleSullaMappaPercentuale;
    private int numeroTotaleSullaSelezione;
    private int daPiazzareSullaSelezione;
    private LOD LOD;

    public Entita() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTotaleSullaMappa() {
        return numeroTotaleSullaMappa;
    }

    public void setNumeroTotaleSullaMappa(int numeroTotaleSullaMappa) {
        this.numeroTotaleSullaMappa = numeroTotaleSullaMappa;
    }

    public float getNumeroTotaleSullaMappaPercentuale() {
        return numeroTotaleSullaMappaPercentuale;
    }

    public void setNumeroTotaleSullaMappaPercentuale(float numeroTotaleSullaMappaPercentuale) {
        this.numeroTotaleSullaMappaPercentuale = numeroTotaleSullaMappaPercentuale;
    }

    public int getNumeroTotaleSullaSelezione() {
        return numeroTotaleSullaSelezione;
    }

    public void setNumeroTotaleSullaSelezione(int numeroTotaleSullaSelezione) {
        this.numeroTotaleSullaSelezione = numeroTotaleSullaSelezione;
    }

    public int getDaPiazzareSullaSelezione() {
        return daPiazzareSullaSelezione;
    }

    public void setDaPiazzareSullaSelezione(int daPiazzareSullaSelezione) {
        this.daPiazzareSullaSelezione = daPiazzareSullaSelezione;
    }

    public LOD getLOD() {
        return LOD;
    }

    public void setLOD(LOD LOD) {
        this.LOD = LOD;
    }

    @Override
    public String toString() {
        return "@entita " +
                "@id::" + id +
                " @numeroTotaleSullaMappa::" + numeroTotaleSullaMappa +
                " @numeroTotaleSullaMappaPercentuale::" + numeroTotaleSullaMappaPercentuale +
                " @numeroTotaleSullaSelezione::" + numeroTotaleSullaSelezione +
                " @daPiazzareSullaSelezione::" + daPiazzareSullaSelezione +
                " @LOD::" + LOD;
    }

    @Override
    public Entita clone() {
        Entita clone = new Entita();

        clone.setId(this.id);
        clone.setNumeroTotaleSullaMappa(numeroTotaleSullaMappa);
        clone.setNumeroTotaleSullaMappaPercentuale(numeroTotaleSullaMappaPercentuale);
        clone.setNumeroTotaleSullaSelezione(numeroTotaleSullaSelezione);
        clone.setDaPiazzareSullaSelezione(daPiazzareSullaSelezione);
        clone.setLOD(this.LOD);

        return clone;
    }
}
