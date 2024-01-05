package it.unisa.IS_Project.AI.MST;

import it.unisa.IS_Project.AI.Entita.EntitaPiazzata;

public class Arco {
    private final String v;
    private final String w;
    private final double peso;

    public Arco(EntitaPiazzata v, EntitaPiazzata w) {
        this.v = v.toString();
        this.w = w.toString();
        this.peso = Math.sqrt(Math.pow((v.getRiga() - w.getRiga()),2) + Math.pow((v.getColonna() - w.getColonna()),2));
    }

    public String getV() {
        return v;
    }

    public String getW() {
        return w;
    }

    public double getWeight() {
        return peso;
    }
}
