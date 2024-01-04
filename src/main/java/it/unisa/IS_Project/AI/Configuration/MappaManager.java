package it.unisa.IS_Project.AI.Configuration;

import it.unisa.IS_Project.AI.Utility.Parser;
import it.unisa.IS_Project.Utility.SessionManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MappaManager {
    private static final MappaManager mm = new MappaManager();
    private int rigaPrimoPuntoDiSelezione;
    private int colonnaPrimoPuntoDiSelezione;
    private int rigaSecondoPuntoDiSelezione;
    private int colonnaSecondoPuntoDiSelezione;
    private int totaleEntitaPiazzate;
    private int larghezzaSelezione;
    private int altezzaSelezione;
    private int totaleCelleAreaSelezione;
    private int[][] mappa;
    private static boolean configurato;

    private MappaManager() { }

    public static MappaManager getInstance() {
        if(!configurato) {
            mm.configura();
            configurato = true;
        }

        return mm;
    }

    private void configura() {
        setLarghezzaSelezione();
        setAltezzaSelezione();
        setTotaleCelleAreaSelezione();
        setTotaleEntitaPiazzate();
        generaLog();
    }

    private void generaLog() {
        String filePath = "src\\main\\java\\it\\unisa\\IS_Project\\AI\\Logs\\mappaLog.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRigaPrimoPuntoDiSelezione(int rigaPrimoPuntoDiSelezione) {
        this.rigaPrimoPuntoDiSelezione = rigaPrimoPuntoDiSelezione;
    }

    public void setColonnaPrimoPuntoDiSelezione(int colonnaPrimoPuntoDiSelezione) {
        this.colonnaPrimoPuntoDiSelezione = colonnaPrimoPuntoDiSelezione;
    }

    public void setRigaSecondoPuntoDiSelezione(int rigaSecondoPuntoDiSelezione) {
        this.rigaSecondoPuntoDiSelezione = rigaSecondoPuntoDiSelezione;
    }

    public void setColonnaSecondoPuntoDiSelezione(int colonnaSecondoPuntoDiSelezione) {
        this.colonnaSecondoPuntoDiSelezione = colonnaSecondoPuntoDiSelezione;
    }

    public void setMappa(int[][] mappa) {
        this.mappa = mappa;
    }

    public int getTotaleEntitaPiazzate() {
        return totaleEntitaPiazzate;
    }

    private void setTotaleEntitaPiazzate() {
        for (int[] riga : mappa)
            for (int id : riga)
                if (id > 0)
                    totaleEntitaPiazzate++;
    }

    public int getLarghezzaSelezione() {
        return larghezzaSelezione;
    }

    private void setLarghezzaSelezione() {
        larghezzaSelezione = colonnaSecondoPuntoDiSelezione - colonnaPrimoPuntoDiSelezione + 1;
    }

    public int getAltezzaSelezione() {
        return altezzaSelezione;
    }

    private void setAltezzaSelezione() {
        altezzaSelezione = rigaSecondoPuntoDiSelezione - rigaPrimoPuntoDiSelezione + 1;
    }

    public int getTotaleCelleAreaSelezione() {
        return totaleCelleAreaSelezione;
    }

    private void setTotaleCelleAreaSelezione() {
        totaleCelleAreaSelezione = larghezzaSelezione * altezzaSelezione;
    }

    public int[][] getMappa() {
        return mappa;
    }

    @Override
    public String toString() {
        return "@log\n\n" +
                "@primoPuntoDiSelezione::(" + rigaPrimoPuntoDiSelezione + "," + colonnaPrimoPuntoDiSelezione + ")" +
                " @secondPuntoDiSelezione::(" + rigaSecondoPuntoDiSelezione + "," + colonnaSecondoPuntoDiSelezione + ")" +
                " @totaleEntitaPiazzate::" + totaleEntitaPiazzate +
                " @larghezzaSelezione::" + larghezzaSelezione +
                " @altezzaSelezione::" + altezzaSelezione +
                " @totaleCelleAreaSelezione::" + totaleCelleAreaSelezione;
    }
}
