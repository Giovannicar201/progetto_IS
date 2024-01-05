package it.unisa.IS_Project.AI.GA;

import it.unisa.IS_Project.AI.Configuration.MappaManager;
import it.unisa.IS_Project.AI.Entita.*;
import it.unisa.IS_Project.AI.MST.Arco;
import it.unisa.IS_Project.AI.MST.Kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Individuo {
    private int[][] areaSelezionata;
    private float valutazione;
    private final static float PESO_PRIMA_FUNZIONE_DI_FITNESS = 60;
    private final static float PESO_SECONDA_FUNZIONE_DI_FITNESS = 40;

    public Individuo() {
        MappaManager mm = MappaManager.getInstance();
        areaSelezionata = new int[mm.getAltezzaSelezione()][mm.getLarghezzaSelezione()];
    }

    public boolean isEmpty(int riga, int colonna) {
        return areaSelezionata[riga][colonna] <= 0;
    }

    public void piazzaEntitaHIGH_LOD(List<Entita> entitaHIGH_LOD) {
        EntitaManager em = EntitaManager.getInstance();
        MappaManager mm = MappaManager.getInstance();
        Random random = new Random();

        int numeroTotaleSullaSelezioneMEDIUM_LOD = em.getNumeroTotaleSullaSelezioneByLOD(LOD.MEDIUM_LOD);
        int numeroTotaleSullaSelezioneLOW_LOD = em.getNumeroTotaleSullaSelezioneByLOD(LOD.LOW_LOD);

        int gap = (numeroTotaleSullaSelezioneMEDIUM_LOD + numeroTotaleSullaSelezioneLOW_LOD) / entitaHIGH_LOD.size();

        int riga = 0;
        int colonna = 0;

        if(entitaHIGH_LOD.isEmpty())
            System.out.println("VUOTTTTTTTTTTTTTOOOOOOOO");

        while(!entitaHIGH_LOD.isEmpty()) {
            Entita entita = entitaHIGH_LOD.get(random.nextInt(entitaHIGH_LOD.size()));
            if(entita.getDaPiazzareSullaSelezione() == 0) {
                entitaHIGH_LOD.remove(entita);
            } else {
                entita.setDaPiazzareSullaSelezione(entita.getDaPiazzareSullaSelezione() - 1);

                System.out.println("RIGA : " + riga);
                System.out.println("COLONNA : " + colonna);
                System.out.println("ID : " + entita.getId());

                areaSelezionata[riga][colonna] = entita.getId();
                colonna += gap + 1;

                if(colonna >= mm.getLarghezzaSelezione()) {
                    riga++;
                    colonna %= mm.getLarghezzaSelezione();
                }
            }
        }
    }

    public void piazzaEntitaMEDIUM_LOD(List<Entita> entitaMEDIUM_LOD) {
        MappaManager mm = MappaManager.getInstance();
        Random random = new Random();

        int riga = 0;
        int colonna = 0;

        while (!entitaMEDIUM_LOD.isEmpty()) {
            if (this.isEmpty(riga, colonna)) {
                Entita entita = entitaMEDIUM_LOD.get(random.nextInt(entitaMEDIUM_LOD.size()));
                if (entita.getDaPiazzareSullaSelezione() == 0) {
                    entitaMEDIUM_LOD.remove(entita);
                    if(colonna == 0) {
                        riga--;
                        colonna = mm.getLarghezzaSelezione();
                    }
                    colonna--;
                } else {
                    entita.setDaPiazzareSullaSelezione(entita.getDaPiazzareSullaSelezione() - 1);
                    areaSelezionata[riga][colonna] = entita.getId();
                }
            }
            colonna++;

            if(colonna >= mm.getLarghezzaSelezione()){
                riga++;
                colonna %= mm.getLarghezzaSelezione();
            }
            if(riga >= mm.getAltezzaSelezione())
                break;
        }
    }

    public void piazzaEntitaLOW_LOD(List<Entita> entitaLOW_LOD) {
        MappaManager mm = MappaManager.getInstance();
        Random random = new Random();

        int riga = 0;
        int colonna = 0;

        while (!entitaLOW_LOD.isEmpty()) {
            if (this.isEmpty(riga, colonna)) {
                Entita entita = entitaLOW_LOD.get(random.nextInt(entitaLOW_LOD.size()));
                if (entita.getDaPiazzareSullaSelezione() == 0) {
                    entitaLOW_LOD.remove(entita);
                    if(colonna == 0) {
                        riga--;
                        colonna = mm.getLarghezzaSelezione();
                    }
                    colonna--;
                } else {
                    entita.setDaPiazzareSullaSelezione(entita.getDaPiazzareSullaSelezione() - 1);
                    areaSelezionata[riga][colonna] = entita.getId();
                }
            }
            colonna++;

            if(colonna >= mm.getLarghezzaSelezione()){
                riga++;
                colonna %= mm.getLarghezzaSelezione();
            }
            if(riga >= mm.getAltezzaSelezione())
                break;
        }
    }

    private float primaFunzioneDiFitness() {
        EntitaManager em = EntitaManager.getInstance();
        List<String> vertici = new ArrayList<>();
        List<Arco> archi = new ArrayList<>();
        List<EntitaPiazzata> entita = new ArrayList<>();

        for (int riga = 0; riga < areaSelezionata.length; riga++)
            for (int colonna = 0; colonna < areaSelezionata[riga].length; colonna++) {
                EntitaPiazzata entitaPiazzata = new EntitaPiazzata(areaSelezionata[riga][colonna], riga, colonna);
                if(em.getLODById(entitaPiazzata.getId()) == LOD.HIGH_LOD) {
                    entita.add(entitaPiazzata);
                    vertici.add(entitaPiazzata.toString());
                }
            }

        for(int i = 0; i < entita.size(); i++) {
            EntitaPiazzata entitaPiazzataV = entita.get(i);
            for(int j = i + 1; j < entita.size(); j++) {
                EntitaPiazzata entitaPiazzataW = entita.get(j);
                Arco edge = new Arco(entitaPiazzataV,entitaPiazzataW);
                archi.add(edge);
            }
        }

        return Kruskal.computaMaxSTCompletamenteConnesso(vertici,archi);
    }

    private float secondaFunzioneDiFitness() {
        EntitaManager em = EntitaManager.getInstance();
        List<String> vertici = new ArrayList<>();
        List<Arco> archi = new ArrayList<>();
        List<EntitaPiazzata> entita = new ArrayList<>();

        for (int riga = 0; riga < areaSelezionata.length; riga++)
            for (int colonna = 0; colonna < areaSelezionata[riga].length; colonna++) {
                EntitaPiazzata entitaPiazzata = new EntitaPiazzata(areaSelezionata[riga][colonna], riga, colonna);
                if(em.getLODById(entitaPiazzata.getId()) == LOD.LOW_LOD) {
                    entita.add(entitaPiazzata);
                    vertici.add(entitaPiazzata.toString());
                }
            }

        for(int i = 0; i < entita.size(); i++) {
            EntitaPiazzata entitaPiazzataV = entita.get(i);
            for(int j = i + 1; j < entita.size(); j++) {
                EntitaPiazzata entitaPiazzataW = entita.get(j);
                Arco edge = new Arco(entitaPiazzataV,entitaPiazzataW);
                archi.add(edge);
            }
        }

        return Kruskal.computaMinSTCompletamenteConnesso(vertici,archi);
    }

    public float getValutazione() {
        valutazione = (PESO_PRIMA_FUNZIONE_DI_FITNESS * primaFunzioneDiFitness() + PESO_SECONDA_FUNZIONE_DI_FITNESS * secondaFunzioneDiFitness()) / (PESO_PRIMA_FUNZIONE_DI_FITNESS + PESO_SECONDA_FUNZIONE_DI_FITNESS);

        return valutazione;
    }

    public int[][] getAreaSelezionata() {
        return areaSelezionata;
    }

    public void setAreaSelezionata(int[][] areaSelezionata) {
        this.areaSelezionata = areaSelezionata;
    }

    public boolean isValid(Map<Integer,Integer> mappaDelleOccorrenze) {
        for (Map.Entry<Integer, Integer> entry : mappaDelleOccorrenze.entrySet())
            if (entry.getValue() != 0)
                return false;

        return true;
    }

    private void rimpiazza(int idDaRimpiazzare, int nuovoId) {
        for (int riga = 0; riga < areaSelezionata.length; riga++)
            for (int colonna = 0; colonna < areaSelezionata[0].length; colonna++)
                if (areaSelezionata[riga][colonna] == idDaRimpiazzare) {
                    areaSelezionata[riga][colonna] = nuovoId;
                    return;
                }
    }

    public void recovery(Map<Integer,Integer> mappaDelleOccorrenze) {
        EntitaManager em = EntitaManager.getInstance();
        int idDaRimpiazzare = 0;
        int nuovoId = 0;

        while(!this.isValid(mappaDelleOccorrenze)) {
            for (Map.Entry<Integer, Integer> entry : mappaDelleOccorrenze.entrySet())
                if (entry.getValue() > 0) {
                    nuovoId = entry.getKey();
                    entry.setValue(entry.getValue() - 1);
                    break;
                }

            for (Map.Entry<Integer, Integer> entry : mappaDelleOccorrenze.entrySet())
                if (entry.getValue() < 0) {
                    idDaRimpiazzare = entry.getKey();
                    entry.setValue(entry.getValue() + 1);
                    break;
                }

            this.rimpiazza(idDaRimpiazzare,nuovoId);
        }
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder("@individual::");

        for (int[] riga : areaSelezionata) {
            risultato.append("\n");
            for (int id : riga)
                risultato.append(id).append("\t");
        }

        risultato.append("\n@valutazione::").append(valutazione).append("\n");

        return risultato.toString();
    }
}
