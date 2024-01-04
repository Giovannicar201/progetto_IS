package it.unisa.IS_Project.AI;

public class Arco {
    private final String v;
    private final String w;
    private final double peso;

    public Arco(EntitaFIA v, EntitaFIA w) {
        this.v = v.toString();
        this.w = w.toString();
        this.peso = Math.sqrt(Math.pow((v.getRow() - w.getRow()),2) + Math.pow((v.getCol() - w.getCol()),2));
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
