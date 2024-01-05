package it.unisa.IS_Project.AI.GA;

import it.unisa.IS_Project.AI.Entita.Entita;
import it.unisa.IS_Project.AI.Entita.EntitaManager;
import it.unisa.IS_Project.AI.Entita.LOD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SteadyStateGAManager {
    private static final SteadyStateGAManager ssm = new SteadyStateGAManager();
    private int dimensionePopolazione;
    private int budgetDiRicerca;
    private final Popolazione popolazione = new Popolazione();
    private static boolean configurato;
    private Individuo individuoMigliore;

    private SteadyStateGAManager() {
    }

    public static SteadyStateGAManager getInstance(int dimensionePopolazione, int budgetDiRicerca) {
        if(!configurato) {
            ssm.configura(dimensionePopolazione,budgetDiRicerca);
            configurato = true;
        }
        
        return ssm;
    }

    private void configura(int dimensionePopolazione, int budgetDiRicerca) {
        this.dimensionePopolazione = dimensionePopolazione;
        this.budgetDiRicerca = budgetDiRicerca;
    }

    public void definisciPopolazioneIniziale() {
        for(int i = 0; i < dimensionePopolazione; i++) {
            Individuo individuo = generaIndividuoPopolazioneIniziale();
            individuo.getValutazione();
            popolazione.aggiungiIndividuo(individuo);
        }
    }

    private Individuo generaIndividuoPopolazioneIniziale() {
        Individuo individuo = new Individuo();

        EntitaManager em = EntitaManager.getInstance();

        List<Entita> entitaHIGH_LOD = em.getEntitaByLOD(LOD.HIGH_LOD);
        System.out.println(entitaHIGH_LOD);
        List<Entita> entitaMEDIUM_LOD = em.getEntitaByLOD(LOD.MEDIUM_LOD);
        System.out.println(entitaMEDIUM_LOD);
        List<Entita> entitaLOW_LOD = em.getEntitaByLOD(LOD.LOW_LOD);
        System.out.println(entitaLOW_LOD);

        individuo.piazzaEntitaHIGH_LOD(entitaHIGH_LOD);
        individuo.piazzaEntitaMEDIUM_LOD(entitaMEDIUM_LOD);
        individuo.piazzaEntitaLOW_LOD(entitaLOW_LOD);

        System.out.println(individuo);

        return individuo;
    }

    public void esegui() {
        individuoMigliore = popolazione.getPopolazione().get(0);

        for(int i = 0; i < budgetDiRicerca; i++) {
            List<Individuo> individui = this.mutazione(this.crossover(this.selezione()));

            popolazione.getPopolazione().sort((primoIndividuo, secondoIndividuo) -> {
                float primaValutazione = primoIndividuo.getValutazione();
                float secondaValutazione = secondoIndividuo.getValutazione();
                return Float.compare(secondaValutazione, primaValutazione);
            });

            Individuo primoIndividuoPeggiore = popolazione.getPopolazione().get(popolazione.getPopolazione().size() - 1);
            Individuo secondoIndividuoPeggiore = popolazione.getPopolazione().get(popolazione.getPopolazione().size() - 2);

            for(Individuo individuo : individui) {
                if(individuo.getValutazione() >= primoIndividuoPeggiore.getValutazione()) {
                    popolazione.getPopolazione().remove(primoIndividuoPeggiore);
                    popolazione.getPopolazione().add(individuo);
                } else if(individuo.getValutazione() >= secondoIndividuoPeggiore.getValutazione()) {
                    popolazione.getPopolazione().remove(secondoIndividuoPeggiore);
                    popolazione.getPopolazione().add(individuo);
                }
            }

            for(Individuo individuo : popolazione.getPopolazione())
                if(individuo.getValutazione() >= individuoMigliore.getValutazione())
                    individuoMigliore = individuo;
        }

        System.out.println("MIGLIORE : " + individuoMigliore);
    }

    private List<Individuo> selezione() {
        List<Individuo> genitori = new ArrayList<>();

        List<Individuo> popolazioneOrdinata = new ArrayList<>(popolazione.getPopolazione());
        popolazioneOrdinata.sort(Comparator.comparing(Individuo::getValutazione).reversed());

        Individuo primoGenitore = popolazioneOrdinata.get(0);
        Individuo secondoGenitore = popolazioneOrdinata.get(1);

        genitori.add(primoGenitore);
        genitori.add(secondoGenitore);

        return genitori;
    }

    private List<Individuo> crossover(List<Individuo> genitori) {
        List<Individuo> figli = new ArrayList<>();
        Random random = new Random();

        int[][] primoGenitore = genitori.get(0).getAreaSelezionata();
        int[][] secondoGenitore = genitori.get(1).getAreaSelezionata();

        int altezza = primoGenitore.length;
        int larghezza = primoGenitore[0].length;

        int[][] primoFiglio = new int[altezza][larghezza];
        int[][] secondoFiglio = new int[altezza][larghezza];

        Map<Integer, Integer> primaMappaDelleOccorrenze = new HashMap<>();
        Map<Integer, Integer> secondaMappaDelleOccorrenze = new HashMap<>();

        for (int[] riga : primoGenitore) {
            for (int id : riga) {
                primaMappaDelleOccorrenze.put(id, primaMappaDelleOccorrenze.getOrDefault(id, 0) + 1);
            }
        }

        for (int[] riga : secondoGenitore) {
            for (int id : riga) {
                secondaMappaDelleOccorrenze.put(id, secondaMappaDelleOccorrenze.getOrDefault(id, 0) + 1);
            }
        }

        for(int riga = 0; riga < altezza; riga++) {
            for(int colonna = 0; colonna < larghezza; colonna++) {
                boolean numeroMassimoPrimoGene = false;
                boolean numeroMassimoSecondoGene = false;
                int primoGene = primoGenitore[riga][colonna];
                int secondoGene = secondoGenitore[riga][colonna];
                double rand = random.nextDouble();

                if (primaMappaDelleOccorrenze.get(primoGene) == 0)
                    numeroMassimoPrimoGene = true;
                if (primaMappaDelleOccorrenze.get(secondoGene) == 0)
                    numeroMassimoSecondoGene = true;

                if(rand > 0.5) {
                    if(numeroMassimoPrimoGene) {
                        primoFiglio[riga][colonna] = secondoGene;
                        secondoFiglio[riga][colonna] = primoGene;
                        primaMappaDelleOccorrenze.replace(secondoGene,primaMappaDelleOccorrenze.get(secondoGene) - 1);
                        secondaMappaDelleOccorrenze.replace(primoGene,secondaMappaDelleOccorrenze.get(primoGene) - 1);
                    } else {
                        primoFiglio[riga][colonna] = primoGene;
                        secondoFiglio[riga][colonna] = secondoGene;
                        primaMappaDelleOccorrenze.replace(primoGene,primaMappaDelleOccorrenze.get(primoGene) - 1);
                        secondaMappaDelleOccorrenze.replace(secondoGene,secondaMappaDelleOccorrenze.get(secondoGene) - 1);
                    }
                } else {
                    if(numeroMassimoSecondoGene) {
                        primoFiglio[riga][colonna] = primoGene;
                        secondoFiglio[riga][colonna] = secondoGene;
                        primaMappaDelleOccorrenze.replace(primoGene,primaMappaDelleOccorrenze.get(primoGene) - 1);
                        secondaMappaDelleOccorrenze.replace(secondoGene,secondaMappaDelleOccorrenze.get(secondoGene) - 1);
                    } else {
                        primoFiglio[riga][colonna] = secondoGene;
                        secondoFiglio[riga][colonna] = primoGene;
                        primaMappaDelleOccorrenze.replace(secondoGene,primaMappaDelleOccorrenze.get(secondoGene) - 1);
                        secondaMappaDelleOccorrenze.replace(primoGene,secondaMappaDelleOccorrenze.get(primoGene) - 1);
                    }
                }
            }
        }

        Individuo primoFiglioIndividuo = new Individuo();
        Individuo secondoFiglioIndividuo = new Individuo();

        primoFiglioIndividuo.setAreaSelezionata(primoFiglio);
        secondoFiglioIndividuo.setAreaSelezionata(secondoFiglio);

        if(!primoFiglioIndividuo.isValid(primaMappaDelleOccorrenze))
            primoFiglioIndividuo.recovery(primaMappaDelleOccorrenze);

        if(!secondoFiglioIndividuo.isValid(secondaMappaDelleOccorrenze))
            secondoFiglioIndividuo.recovery(secondaMappaDelleOccorrenze);

        figli.add(primoFiglioIndividuo);
        figli.add(secondoFiglioIndividuo);

        return figli;
    }

    private List<Individuo> mutazione(List<Individuo> figli) {
        Random random = new Random();
        int rigaMassima = figli.get(0).getAreaSelezionata().length;
        int colonnaMassima = figli.get(0).getAreaSelezionata()[0].length;

        for(Individuo individuo : figli) {
            int primaRiga = random.nextInt(rigaMassima);
            int primaColonna = random.nextInt(colonnaMassima);
            int primoId = individuo.getAreaSelezionata()[primaRiga][primaColonna];
            int secondaRiga = random.nextInt(rigaMassima);
            int secondaColonna = random.nextInt(colonnaMassima);
            int secondoId = individuo.getAreaSelezionata()[secondaRiga][secondaColonna];
            individuo.getAreaSelezionata()[secondaRiga][secondaColonna] = primoId;
            individuo.getAreaSelezionata()[primaRiga][primaColonna] = secondoId;
        }

        return figli;
    }
}
