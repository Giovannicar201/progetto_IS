package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Utility.UtilityClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Questa classe viene utilizzata per fornire il mapping delle pagine html
 * del progetto, la clausola @GetMapping("URL") viene utilizzata per dire a
 * spring che si tratta di un mapping di una jsp, thymeleaf viene utilizzato per
 * trasformare un file html in una jlst in mopo automatico.
 *
 */

@Controller

public class HTMLMapping {

    /**
     * GetMapping mappa l'url associato al file html
     * @return il nome del file html associato alla home page
     */

    @GetMapping("/")

    public String index() {

        return "homepage";

    }

    /**
     * GetMapping mappa l'url associato al file html
     * @return il nome del file html associato alla griglia
     */

    @GetMapping("/griglia")

    public String griglia() {

        return "Griglia";

    }

    /**
     * GetMapping mappa l'url associato al file html
     * @return il nome del file html associato al login
     */

    @GetMapping("/login")

    public String login() {

        return "login-regist";

    }

    @GetMapping("/pixelArt")

    public String pixelArt () {

        return "PixelArtCreator";

    }

    @GetMapping("/pacchetti")

    public String pacchetti () {

        return "pacchetti";
    }

    @GetMapping("/carrello")

    public String carrello () {

        return "carrello";
    }

}
