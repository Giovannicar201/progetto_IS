package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.CartellaEntity;
import it.unisa.IS_Project.Model.Service.ImmagineService;
import it.unisa.IS_Project.Utility.UtilityClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig
@Controller
public class ImmagineControl {
    @Autowired
    public ImmagineService immagineService;
    @RequestMapping(value = "/caricaImmagine", method = RequestMethod.POST)

    public String caricaImmagine(@RequestBody Part immagine, HttpServletRequest request) throws ServletException, IOException {
        String email = UtilityClass.emailSessione(request);

        immagineService.add(immagine,"",email);

        return "griglia";

    }

    @RequestMapping(value = "/griglia/trovaCartelle", method = RequestMethod.GET)

    public String trovaCartelle(HttpServletRequest request) {

        List<CartellaEntity> cartelle = immagineService.get()

        return "griglia";

    }
}
