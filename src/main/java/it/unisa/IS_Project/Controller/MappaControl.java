package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Exception.Session.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Service.MappaService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappaControl {
    @Autowired
    public MappaService mappaService;

    @RequestMapping(value = "/gestoreMappa/creaMappa", method = RequestMethod.POST)

    public void creaMappa(@RequestBody String mappa, HttpServletRequest request, HttpServletResponse response) {

        JSONParser parser = new JSONParser();
        String email, nome;
        Integer lunghezza, larghezza;

        try {

            JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

            email = SessionManager.getEmail(request);
            nome = (String) mappaJSON.get("nome");
            lunghezza = (Integer) mappaJSON.get("lunghezza");
            larghezza = (Integer) mappaJSON.get("larghezza");

            SessionManager.setMappa(request,mappaService.creaMappa(email,nome,lunghezza,larghezza));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionEmailException e) {
            throw new RuntimeException(e);
        }
    }
}
