package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Model.Entity.IstruzioneEntity;
import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Service.EventoService;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.Utility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventoControl {

    @Autowired
    public EventoService eventoService;
    @Autowired
    public UtenteService utenteService;

    /*@RequestMapping(value = "/eventi/creaEvento", method = RequestMethod.POST)

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
            email = Utility.emailSessione(request);
        } catch (MissingSessionEmailException e) {
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

    }*/

    /*@RequestMapping(value = "/griglia/trovaEventi", method = RequestMethod.GET)
    @ResponseBody
    public String trovaEventi(HttpServletRequest request, HttpServletResponse response, Model model) {

        JSONObject eventiJSON = new JSONObject();
        JSONArray nomiEventi = new JSONArray();
        List<EventoEntity> eventi;

        try {

            eventi = eventoService.getAllEvento(Utility.emailSessione(request));

        } catch (MissingSessionEmailException e) {

            model.addAttribute("error", "ERROR - YOU ARE NOT LOGGED.");

            return "LogInRegistrazione";
        }

        for(EventoEntity eventoEntity : eventi)
            nomiEventi.add(eventoEntity.getNome());


        eventiJSON.put("nomiEventi", eventiJSON);

        response.setContentType("text/plain");

        return eventiJSON.toString();
    }*/
}
