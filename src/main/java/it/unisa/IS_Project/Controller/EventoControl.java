package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Logout.EmptySessionException;
import it.unisa.IS_Project.Model.Service.EventoService;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventoControl {

    @Autowired
    public EventoService eventoService;
    @Autowired
    public UtenteService utenteService;

    @RequestMapping(value = "/eventi/creaEvento", method = RequestMethod.POST)

    public String creaEvento(@RequestBody String evento, HttpServletRequest request){

        System.out.println(evento);

        JSONParser parser = new JSONParser();
        JSONObject eventoJSON;
        JSONArray istruzioni;

        System.out.println("ARRIVATO");

        try {
            eventoJSON = (JSONObject) parser.parse(evento);
        } catch (ParseException e) {
            return "redirect:/error";
        }

        String email = null;
        try {
            email = UtilityClass.emailSessione(request);
        } catch (EmptySessionException e) {
            throw new RuntimeException(e);
        }
        String nome = (String) eventoJSON.get("nome");

        eventoService.add(nome,email);

        istruzioni = (JSONArray) eventoJSON.get("istruzioni");

       for(Object obj : istruzioni) {
           JSONObject objJSON = (JSONObject) obj;
           String nomeIstruzione = (String) objJSON.get("nome");
           String valoreIstruzione = (String) objJSON.get("valore");
           IstruzioneEntity istruzione = new IstruzioneEntity();
           istruzione.setNome(nomeIstruzione);
           istruzione.setValore(valoreIstruzione);
           istruzione.setEventoEntity(eventoService.get(nome));
           istruzione.setIdEvento(eventoService.get(nome).getIdEvento());
       }

        return "eventmanager";

    }

    @RequestMapping(value = "/eventi/visualizzaAnteprima", method = RequestMethod.POST)

    public String visualizzaAnteprima(@RequestBody String evento, HttpServletRequest request){

        return "redirect:/login";

    }

    @RequestMapping(value = "/eventi/eliminaEvento", method = RequestMethod.POST)

    public String eliminaEvento(@ModelAttribute EventoEntity eventoEntity){

        return "redirect:/login";

    }

    @RequestMapping(value = "/eventi/getEventi", method = RequestMethod.POST)

    public String getListaEventi(@ModelAttribute EventoEntity eventoEntity){

        return "redirect:/login";

    }
}
