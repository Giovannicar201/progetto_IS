package it.unisa.IS_Project.AI.GA;

import java.util.ArrayList;
import java.util.List;

public class Popolazione {

    private final List<Individuo> popolazione = new ArrayList<>();

    public Popolazione() {
    }

    public void aggiungiIndividuo(Individuo individuo) {
        popolazione.add(individuo);
    }

    public List<Individuo> getPopolazione() {
        return popolazione;
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder("@log\n\n");

        for (Individuo individuo : popolazione)
            risultato.append(individuo.toString()).append("\n");

        return risultato.toString();
    }
    
}
