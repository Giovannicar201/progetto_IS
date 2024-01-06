package it.unisa.IS_Project.AI.Service;

import it.unisa.IS_Project.AI.Manager.EntitaManager;
import it.unisa.IS_Project.AI.Manager.MappaManager;
import it.unisa.IS_Project.AI.Entity.IndividuoEntity;
import it.unisa.IS_Project.AI.Manager.SteadyStateGAManager;
import it.unisa.IS_Project.AI.Utility.Parser;
import org.json.simple.parser.ParseException;

public class IAServiceImpl {

    public String genera(String mappa, int rigaPrimoPuntoDiSelezione, int colonnaPrimoPuntoDiSelezione, int rigaSecondoPuntoDiSelezione, int colonnaSecondoPuntoDiSelezione) throws ParseException {

        MappaManager.configura(mappa,rigaPrimoPuntoDiSelezione,colonnaPrimoPuntoDiSelezione,rigaSecondoPuntoDiSelezione,colonnaSecondoPuntoDiSelezione);
        EntitaManager.configura();

        SteadyStateGAManager ssm = SteadyStateGAManager.getInstance(30,10);

        ssm.definisciPopolazioneIniziale();

        IndividuoEntity individuoMigliore = ssm.esegui();

        return Parser.convertiIndividuo(individuoMigliore.getAreaSelezionata(),rigaPrimoPuntoDiSelezione,colonnaPrimoPuntoDiSelezione);
    }
}
