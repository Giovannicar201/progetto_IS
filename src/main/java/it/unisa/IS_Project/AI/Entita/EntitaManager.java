package it.unisa.IS_Project.AI.Entita;

import it.unisa.IS_Project.AI.Configuration.MappaManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EntitaManager {
    private static final EntitaManager epm = new EntitaManager();
    private static final List<Entita> listaEntita = new ArrayList<>();
    private static boolean configurato;

    public EntitaManager() {
    }

    public static EntitaManager getInstance() {
        if(!configurato) {
            epm.configura();
            configurato = true;
        }
        return epm;
    }
    private void configura() {
        setOgniNumeroTotaleSullaMappa();
        setOgniNumeroTotaleSullaMappaPercentuale();
        setOgniNumeroTotaleSullaSelezione();
        setOgniDaPiazzareSullaSelezione();
        setOgniLOD();
        generaLog();
    }

    private void generaLog() {
        String filePath = "src\\main\\java\\it\\unisa\\IS_Project\\AI\\Logs\\entitaLog.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setOgniNumeroTotaleSullaMappa() {
        MappaManager mm = MappaManager.getInstance();
        List<Integer> ids = new ArrayList<>();

        int[][] map = mm.getMappa();

        for (int[] row : map)
            for (int id : row)
                if (!ids.contains(id) && id > 0) {
                    ids.add(id);
                    Entita entita = new Entita();
                    entita.setId(id);
                    entita.setNumeroTotaleSullaMappa(1);
                    listaEntita.add(entita);
                } else if (ids.contains(id) && id > 0) {
                    for (Entita entita : listaEntita)
                        if (entita.getId() == id)
                            entita.setNumeroTotaleSullaMappa(entita.getNumeroTotaleSullaMappa() + 1);
                }
    }

    private void setOgniNumeroTotaleSullaMappaPercentuale() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);

        MappaManager mm = MappaManager.getInstance();
        int totaleEntitaPiazzate = mm.getTotaleEntitaPiazzate();

        for(Entita entita : listaEntita) {
            float totaleSullaMappaPercentuale = (float) entita.getNumeroTotaleSullaMappa() / totaleEntitaPiazzate;
            String formattedTotalOverMapRate = df.format(totaleSullaMappaPercentuale * 100f);

            totaleSullaMappaPercentuale = Float.parseFloat(formattedTotalOverMapRate);

            entita.setNumeroTotaleSullaMappaPercentuale(totaleSullaMappaPercentuale);
        }
    }

    private void setOgniNumeroTotaleSullaSelezione() {
        MappaManager mm = MappaManager.getInstance();
        int sommaNumeroTotaleSullaSelezione = 0;

        for(Entita entita : listaEntita){
            float totalOverSelection = (entita.getNumeroTotaleSullaMappaPercentuale() * mm.getTotaleCelleAreaSelezione()) / 100;
            float fractionalPart = totalOverSelection - (int) totalOverSelection;

            if(fractionalPart >= 0.5f)
                entita.setNumeroTotaleSullaSelezione((int) Math.ceil(totalOverSelection));
            else
                entita.setNumeroTotaleSullaSelezione((int) Math.floor(totalOverSelection));

            sommaNumeroTotaleSullaSelezione += entita.getNumeroTotaleSullaSelezione();
        }

        /*
         * Approssimando per difetto è possibile che la somma del numero di entità da piazzare non coincida
         * con il numero di celle da riempire dell'area selezionata. Per tale motivo è necessario reintegrare
         * tali valori.
         * */

        if(sommaNumeroTotaleSullaSelezione < mm.getTotaleCelleAreaSelezione()) {
            int totaleSullaSelezioneDaAggiungere = (mm.getTotaleCelleAreaSelezione() - sommaNumeroTotaleSullaSelezione);

            Entita entitaConPercentualeMaggiore = listaEntita.get(0);

            for(Entita entita : listaEntita)
                if(entita.getNumeroTotaleSullaMappaPercentuale() >= entitaConPercentualeMaggiore.getNumeroTotaleSullaMappaPercentuale())
                    entitaConPercentualeMaggiore = entita;

            entitaConPercentualeMaggiore.setNumeroTotaleSullaSelezione(entitaConPercentualeMaggiore.getNumeroTotaleSullaSelezione() + totaleSullaSelezioneDaAggiungere);
        }

        /*
         * Nel caso in cui il numero di entità univoche è maggiore del numero di celle dell'area selezionata
         * allora il numero di volte che alcune di queste entità dovranno essere piazzate sarà pari a zero.
         * */

        for(int i = mm.getTotaleCelleAreaSelezione(); i < listaEntita.size(); i++)
            listaEntita.get(i).setNumeroTotaleSullaSelezione(0);
    }

    private void setOgniDaPiazzareSullaSelezione() {
        for(Entita entita : listaEntita)
            entita.setDaPiazzareSullaSelezione(entita.getNumeroTotaleSullaSelezione());
    }

    private void setOgniLOD() {
        Entita entityWithMinRate = listaEntita.get(0);
        Entita entityWithMaxRate = listaEntita.get(0);

        float percentualeMinima = entityWithMinRate.getNumeroTotaleSullaMappaPercentuale();
        float percentualeMassima = entityWithMaxRate.getNumeroTotaleSullaMappaPercentuale();

        for(int i = 1; i < listaEntita.size(); i++) {
            if (listaEntita.get(i).getNumeroTotaleSullaMappaPercentuale() < percentualeMinima)
                percentualeMinima = listaEntita.get(i).getNumeroTotaleSullaMappaPercentuale();
            else if (listaEntita.get(i).getNumeroTotaleSullaMappaPercentuale() > percentualeMassima)
                percentualeMassima = listaEntita.get(i).getNumeroTotaleSullaMappaPercentuale();
        }

        float centralSplit = (percentualeMinima + percentualeMassima) / 2;
        float leftSplit = (percentualeMinima + centralSplit) / 2;
        float rightSplit = (centralSplit + percentualeMassima) / 2;

        for(Entita entita : listaEntita){
            float numeroTotaleSullaMappaPercentuale = entita.getNumeroTotaleSullaMappaPercentuale();
            if(numeroTotaleSullaMappaPercentuale >= percentualeMinima && numeroTotaleSullaMappaPercentuale < leftSplit)
                entita.setLOD(LOD.HIGH_LOD);
            else if(numeroTotaleSullaMappaPercentuale >= leftSplit && numeroTotaleSullaMappaPercentuale < rightSplit)
                entita.setLOD(LOD.MEDIUM_LOD);
            else if(numeroTotaleSullaMappaPercentuale >= rightSplit && numeroTotaleSullaMappaPercentuale <= percentualeMassima)
                entita.setLOD(LOD.LOW_LOD);
        }
    }

    public List<Entita> getEntitaByLOD(LOD LOD) {
        List<Entita> entitaByLOD = new ArrayList<>();

        for(Entita entita : listaEntita)
            if (entita.getLOD() == LOD)
                entitaByLOD.add(entita.clone());

        return entitaByLOD;
    }

    public int getNumeroTotaleSullaSelezioneByLOD(LOD LOD) {
        List<Entita> entitaByLOD = getEntitaByLOD(LOD);

        return entitaByLOD.stream().mapToInt(Entita::getNumeroTotaleSullaSelezione).sum();
    }

    public List<Entita> getUniqueEntitiesList() {
        List<Entita> entitaCloned = new ArrayList<>();

        for(Entita entita : listaEntita)
            entitaCloned.add(entita.clone());

        return entitaCloned;
    }

    public LOD getLODById(int id) {
        LOD LOD = null;

        for(Entita entita : listaEntita)
            if(entita.getId() == id)
                LOD = entita.getLOD();

        return LOD;
    }

    public Entita getEntitaById(int id) {
        Entita entitaTrovata = new Entita();

        for(Entita entita : listaEntita)
            if(entita.getId() == id)
                entitaTrovata = entita.clone();

        return entitaTrovata;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("@log\n\n");

        for(Entita entita : listaEntita)
            result.append(entita.toString()).append("\n");

        return result.toString();
    }

}
