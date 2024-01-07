package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Exception.GEN.GEN.CreateEntityException;
import it.unisa.IS_Project.Model.Entity.EventoEntity;
import it.unisa.IS_Project.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Service.EventoService;
import it.unisa.IS_Project.Model.Service.UtenteService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

    @RequestMapping(value = "/gestoreEventi/creaEvento", method = RequestMethod.POST)

    public String creaEvento(@RequestBody String evento,
                             HttpServletRequest request, HttpServletResponse response) {
       /* JSONParser parser = new JSONParser();
        List<String> nomiIstruzioni = new ArrayList<>();
        List<String> valoriIstruzioni = new ArrayList<>();
        String email, nome, riga, colonna;

        try {

            JSONObject entitaJSON = (JSONObject) parser.parse(evento);

            email = SessionManager.getEmail(request);
            nome = (String) entitaJSON.get("nome");
            riga = (String) entitaJSON.get("riga");
            colonna = (String) entitaJSON.get("colonna");

            JSONArray istruzioni = (JSONArray) entitaJSON.get("istruzioni");

            for(Object obj : istruzioni) {
                JSONObject istruzioneJSON = (JSONObject) obj;

                String nomeIstruzione = (String) istruzioneJSON.get("nomeIstruzione");
                String valoreIstruzione = (String) istruzioneJSON.get("valoreIstruzione");

                nomiIstruzioni.add(nomeIstruzione);
                valoriIstruzioni.add(valoreIstruzione);
            }

            eventoService.creaEvento(email,nome,riga,colonna,nomiIstruzioni,valoriIstruzioni);

        } catch (ParseException e) {

            try {
                response.sendError(302, "NQTE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ PARSEEXCEPTION.");
            }

        } catch (MissingSessionEmailException e) {

            try {
                response.sendError(302, "MSEE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (FolderNotFoundException e) {

            try {
                response.sendError(500, "MSEE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidEntityNameException e) {

            try {
                response.sendError(500, "IENE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidNumberOfPropertyException e) {

            try {
                response.sendError(500, "INPE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (NotUniqueEntityException e) {

            try {
                response.sendError(500, "NUEE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (ImageNotFoundException e) {

            try {
                response.sendError(500, "INFE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        } catch (InvalidCollisionException e) {

            try {
                response.sendError(500, "ICE");
            } catch (IOException ex) {
                throw new CreateEntityException("ERRORE - CREAZIONE ENTITÀ IOEXCEPTION.");
            }

        }*/

        return evento;
    }

    @RequestMapping(value = "/gestoreEventi/visualizzaAnteprima", method = RequestMethod.POST)

    public String visualizzaAnteprimaEvento(@RequestBody String evento, HttpServletRequest request){

        return "redirect:/login";

    }

    @RequestMapping(value = "/gestoreEventi/eliminaEvento", method = RequestMethod.POST)

    public String eliminaEvento(@ModelAttribute EventoEntity eventoEntity){

        return "redirect:/login";

    }

    @RequestMapping(value = "/gestoreEventi/trovaEventi", method = RequestMethod.GET)
    @ResponseBody
    public String visualizzaListaEventi(HttpServletRequest request, HttpServletResponse response, Model model) {

        JSONObject eventiJSON = new JSONObject();
        JSONArray nomiEventi = new JSONArray();
        List<EventoEntity> eventi;

        try {

            eventi = eventoService.getAllEvento(SessionManager.getEmail(request));

        } catch (MissingSessionEmailException e) {

            model.addAttribute("error", "ERROR - YOU ARE NOT LOGGED.");

            return "LogInRegistrazione";
        }

        for(EventoEntity eventoEntity : eventi)
            nomiEventi.add(eventoEntity.getNome());


        eventiJSON.put("nomiEventi", eventiJSON);

        response.setContentType("text/plain");

        return eventiJSON.toString();
    }
}
