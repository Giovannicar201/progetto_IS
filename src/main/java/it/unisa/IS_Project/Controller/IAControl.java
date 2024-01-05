package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.AI.Configuration.MappaManager;
import it.unisa.IS_Project.AI.GA.SteadyStateGAManager;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapSelectionException;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IAControl {

    @RequestMapping(value = "/IA/genera", method = RequestMethod.POST)

    public void genera(HttpServletRequest request, HttpServletResponse response) {

        JSONParser parser = new JSONParser();

        try {

            JSONObject selezioneJSON = new JSONObject();

            selezioneJSON.put("primaRiga","0");
            selezioneJSON.put("primaColonna","0");
            selezioneJSON.put("secondaRiga","6");
            selezioneJSON.put("secondaColonna","6");

            SessionManager.setSelezioneMappa(request,selezioneJSON.toString());

            System.out.println(SessionManager.getSelezioneMappa(request));


            selezioneJSON = (JSONObject) parser.parse(SessionManager.getSelezioneMappa(request));
            String mappa = SessionManager.getMappa(request);

            int primaRiga = Integer.parseInt((String) selezioneJSON.get("primaRiga"));
            int primaColonna = Integer.parseInt((String) selezioneJSON.get("primaColonna"));
            int secondaRiga = Integer.parseInt((String) selezioneJSON.get("secondaRiga"));
            int secondaColonna = Integer.parseInt((String) selezioneJSON.get("secondaColonna"));

            System.out.println("COORD : " + primaColonna + " " + primaRiga + " " + secondaColonna + " " +secondaRiga);

            MappaManager.configura(primaRiga,primaColonna,secondaRiga,secondaColonna,mappa);
            MappaManager mm = MappaManager.getInstance();
            SteadyStateGAManager ssm = SteadyStateGAManager.getInstance(30,10);
            ssm.definisciPopolazioneIniziale();
            ssm.esegui();

        } catch (MissingSessionMapSelectionException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionMapException e) {
            throw new RuntimeException(e);
        }

    }

}
