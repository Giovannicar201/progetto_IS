package it.unisa.IS_Project.AI.Entita;

public class EntitaPiazzata {

    private int id;
    private int riga;
    private int colonna;

    public EntitaPiazzata(int id, int riga, int colonna) {
        this.id = id;
        this.riga = riga;
        this.colonna = colonna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRiga() {
        return riga;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    @Override
    public String toString() {
        return "@entita " +
                "@id::" + id +
                " @colonna::" + colonna +
                " @riga::" + riga;
    }

    @Override
    public EntitaPiazzata clone() throws CloneNotSupportedException {
        EntitaPiazzata clone = (EntitaPiazzata) super.clone();

        clone.setId(id);
        clone.setColonna(colonna);
        clone.setRiga(riga);

        return clone;
    }
}
