package it.unisa.IS_Project.AI.Entita;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntitaManager {
    private static final EntitaManager em = new EntitaManager();
    private static final List<Entita> entita = new ArrayList<>();
    private static boolean configurato;

    private EntitaManager() {
    }

    public static EntitaManager getInstance() {
        if(!configurato) {
            em.configura();
            configurato = true;
        }

        return em;
    }
    private void configura() {
        setEveryEntity();
        generaLog();
    }

    private void generaLog() {
        String filePath = "src\\main\\java\\it\\unisa\\files\\logs\\entitiesLog.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setEveryEntity() {
        /*MapPropertiesManager mpm = MapPropertiesManager.getInstance();

        int[][] map = mpm.getMap();

        for (int row = 0; row < map.length; row++)
            for (int col = 0; col < map[row].length; col++) {
                Entity entity = new Entity(map[row][col], row, col);
                entities.add(entity);
            }*/
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder("@log\n\n");

        for(Entita entita : entita)
            risultato.append(entita.toString()).append("\n");

        return risultato.toString();
    }
}
