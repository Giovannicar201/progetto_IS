package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.AI.Service.IAServiceAdapter;
import it.unisa.IS_Project.AI.Utility.Parser;
import it.unisa.IS_Project.Model.Entity.EntitaEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GEN.EntityNotFoundException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.InvalidRowException;
import it.unisa.IS_Project.Model.Exception.GMP.GST.Selezione.InvalidColumnException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionEmailException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapException;
import it.unisa.IS_Project.Model.Exception.Sessione.MissingSessionMapSelectionException;
import it.unisa.IS_Project.Model.Repository.EntitaRepository;
import it.unisa.IS_Project.Model.Service.EntitaService;
import it.unisa.IS_Project.Model.Service.MatitaService;
import it.unisa.IS_Project.Utility.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

@Controller
public class IAControl {
    @Qualifier("matitaServiceMappaImpl")
    @Autowired
    protected MatitaService matitaService;
    @Autowired
    protected EntitaService entitaService;
    @Autowired
    protected EntitaRepository entitaRepository;

    @RequestMapping(value = "/IA/genera", method = RequestMethod.POST)

    public void genera(HttpServletRequest request, HttpServletResponse response) {

        JSONParser parser = new JSONParser();

        try {

            SessionManager.getEmail(request);

            String mappa = SessionManager.getMappa(request);

            System.out.println(Arrays.deepToString(Parser.convertiMappa(SessionManager.getMappa(request))));

            JSONObject selezioneJSON = (JSONObject) parser.parse(SessionManager.getSelezioneMappa(request));

            String rigaPrimoPunto = (String) selezioneJSON.get("primaRiga");
            String colonnaPrimoPunto = (String) selezioneJSON.get("primaColonna");
            String rigaSecondoPunto = (String) selezioneJSON.get("secondaRiga");
            String colonnaSecondoPunto = (String) selezioneJSON.get("secondaColonna");

            IAServiceAdapter iaServiceAdapter = new IAServiceAdapter();
            String individuo = iaServiceAdapter.genera(mappa,rigaPrimoPunto,colonnaPrimoPunto,rigaSecondoPunto,colonnaSecondoPunto);

            JSONObject individuoJSON = (JSONObject) parser.parse(individuo);

            JSONObject mappaJSON = (JSONObject) parser.parse(mappa);

            JSONArray entitaIndividuo = (JSONArray) individuoJSON.get("entita");

            JSONArray entita = (JSONArray) mappaJSON.get("mappa");

            for(Object obj : entitaIndividuo) {
                JSONObject entitaIndividuoJSON = (JSONObject) obj;

                int id = Math.toIntExact((Long) entitaIndividuoJSON.get("id"));

                String nome = entitaRepository.findById(id).getNome();
                String riga = (String) entitaIndividuoJSON.get("riga");
                String colonna = (String) entitaIndividuoJSON.get("colonna");

                EntitaEntity entitaEntityQuery = entitaService.get(nome);

                for (Object entitaOBJ : entita) {
                    JSONObject entitaJSON = (JSONObject) entitaOBJ;

                    if (((String) entitaJSON.get("riga")).compareTo(riga) == 0 &&
                            ((String) entitaJSON.get("colonna")).compareTo(colonna) == 0) {

                        System.out.println("ENTRATO");

                        entitaJSON.put("id", entitaEntityQuery.getId());

                        Blob immagine = entitaEntityQuery.getImmagineEntity().getFoto();
                        byte[] bytes = immagine.getBytes(1, (int) immagine.length());

                        entitaJSON.put("immagine", Base64.getEncoder().encodeToString(bytes));
                    }
                }
            }

            mappaJSON.put("mappa",entita);

            SessionManager.setMappa(request,mappaJSON.toString());

            System.out.println(Arrays.deepToString(Parser.convertiMappa(SessionManager.getMappa(request))));

        } catch (MissingSessionMapSelectionException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionMapException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (MissingSessionEmailException e) {
            throw new RuntimeException(e);
        }

    }

}
