package it.unisa.IS_Project.AI.Service;

import it.unisa.IS_Project.Model.Service.IAService;
import org.json.simple.parser.ParseException;

public class IAServiceAdapter implements IAService {
    private final IAServiceImpl iaService;

    public IAServiceAdapter() {
        iaService = new IAServiceImpl();
    }

    @Override
    public String genera(String mappa, String rigaPrimoPuntoDiSelezione, String colonnaPrimoPuntoDiSelezione, String rigaSecondoPuntoDiSelezione, String colonnaSecondoPuntoDiSelezione) throws ParseException {

        int rigaPrimoPunto = Integer.parseInt(rigaPrimoPuntoDiSelezione);
        int colonnaPrimoPunto = Integer.parseInt(colonnaPrimoPuntoDiSelezione);
        int rigaSecondoPunto = Integer.parseInt(rigaSecondoPuntoDiSelezione);
        int colonnaSecondoPunto = Integer.parseInt(colonnaSecondoPuntoDiSelezione);

        return iaService.genera(mappa,rigaPrimoPunto,colonnaPrimoPunto,rigaSecondoPunto,colonnaSecondoPunto);
    }
}
