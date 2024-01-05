package it.unisa.IS_Project.AI.Entita;

import it.unisa.IS_Project.AI.Configuration.MappaManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntitaPiazzataManager {
    private static final EntitaPiazzataManager em = new EntitaPiazzataManager();
    private static final List<EntitaPiazzata> entitaPiazzate = new ArrayList<>();
    private static boolean configurato;

    private EntitaPiazzataManager() {
    }

    public static EntitaPiazzataManager getInstance() {
        if(!configurato) {
            em.configura();
            configurato = true;
        }

        return em;
    }
    public void configura() {
        setListaEntita();
        generaLog();
    }

    private void generaLog() {
        String filePath = "src\\main\\java\\it\\unisa\\IS_Project\\AI\\Logs\\entitaPiazzateLog.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setListaEntita() {
        MappaManager mm = MappaManager.getInstance();

        int[][] map = mm.getMappa();

        for (int riga = 0; riga < map.length; riga++)
            for (int colonna = 0; colonna < map[riga].length; colonna++) {
                EntitaPiazzata entity = new EntitaPiazzata(map[riga][colonna], riga, colonna);
                entitaPiazzate.add(entity);
            }
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder("@log\n\n");

        for(EntitaPiazzata entitaPiazzata : entitaPiazzate)
            risultato.append(entitaPiazzata.toString()).append("\n");

        return risultato.toString();
    }
}
