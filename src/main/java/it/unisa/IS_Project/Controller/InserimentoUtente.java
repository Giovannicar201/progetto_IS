package it.unisa.IS_Project.Controller;

import it.unisa.IS_Project.Model.Entity.*;
import it.unisa.IS_Project.Model.Repository.ImmagineRepository;
import it.unisa.IS_Project.Model.Repository.MappaRepository;
import it.unisa.IS_Project.Model.Service.*;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InserimentoUtente {
    @Autowired
    private UtenteService utenteService;
    /*@Autowired
    private PService paletteService;*/
    @Autowired
    private ImmagineService immagineService;
    @Autowired
    private CartellaService cartellaService;
    @Autowired
    private MappaService mappaService;
    @Autowired
    private PaletteService paletteService;
    @Autowired
    private ColoreService coloreService;
    @Autowired
    private EntitaService entitaService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private IstruzioneService istruzioneService;

    @PostMapping("/inserimentoUtente")
    public String addNewUtente(@RequestParam("email")String email, @RequestParam("password")String password, @RequestParam("nome")String nome, Model model){
        UtenteEntity entity=utenteService.add(email,password,nome);
        model.addAttribute("utente",entity);
        return "testDb";
    }

    /*@PostMapping("/inserimentoCartella")
    public String addNewCartella(@RequestParam("nomeCartella")String nome,@RequestParam("email1")String email,Model model){
        UtenteModel utenteModel = utenteService.get(email);

        if (utenteModel != null) {
            CartellaModel cartellaModel = new CartellaModel();
            cartellaModel.setNome(nome);
            cartellaModel.setCartellaUtente(utenteModel);

            cartellaService.add(cartellaModel);

            model.addAttribute("cartella", cartellaModel);
        } else {
            // Utente non trovato, gestisci di conseguenza
            model.addAttribute("errore", "Utente non trovato");
        }
        return "testDb";
    }*/
    /*@PostMapping("/inserimentoCartella")
    public String addNewCartella(@RequestParam("nomeCartella") String nomeCartella, @RequestParam("email") String emailUtente, Model model) {
        CartellaModel cartellaModel=new CartellaModel();
        UtenteModel utenteModel = utenteService.get(emailUtente);

        cartellaModel.setNome(nomeCartella);
        cartellaModel.setCartellaUtente(utenteModel);
        cartellaService.add(cartellaModel);
        model.addAttribute("cartella",cartellaModel);
        return "testDb";
    }*/

    /*@PostMapping("/inserimentoCartella")
    public String addNewCartella(@RequestParam("nomeCartella") String nomeCartella, @RequestParam("email") String emailUtente, Model model) {

        UtenteModel utenteModel = utenteService.get(emailUtente);

        if (utenteModel == null) {
            // Gestisci il caso in cui l'utente non è trovato
            throw new EntityNotFoundException("Utente non trovato per l'email: " + emailUtente);
        }

        System.out.println("Utente recuperato con successo: " + utenteModel);

        CartellaModel cartellaModel = new CartellaModel();
        cartellaModel.setNome(nomeCartella);
        cartellaModel.setEmailUtente(utenteModel);

        CartellaModel saved = cartellaService.addNew(cartellaModel, emailUtente);

        model.addAttribute("cartella", saved);

        return "testDb";
    }*/

    /*@PostMapping("/updateCartella")
    public String updateCartella(@RequestParam("email1")String email, @ModelAttribute("idCartella")int idCartella, Model model){
        UtenteModel utenteModel = utenteService.get(email);
        CartellaModel cartellaModel = cartellaService.get(idCartella);

        utenteModel.setIdCartella(cartellaModel);

        utenteService.updateCartella(utenteModel, email, idCartella);

        model.addAttribute("utente1",utenteModel);
        return "testDb";
    }*/

    /*@PostMapping(value = "/inserimentoCartella")
    public ResponseEntity<CartellaModel> addNewCartella(@RequestParam("nomeCartella")String nomeCartella, @RequestParam("email")String email, Model model) {
        CartellaModel cartellaModel1 = new CartellaModel();
        cartellaModel1.setNome(nomeCartella);

        UtenteModel utenteModel = utenteService.get(email);

        if (utenteModel != null) {
            utenteModel.setEmail(email);
            cartellaModel1.setEmailUtente(utenteModel);

            CartellaModel saved = cartellaService.add(cartellaModel1);

            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } else {
            // Gestisci il caso in cui l'utente non esiste
            // Puoi restituire un messaggio di errore o gestire diversamente
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }*/

    /*@PostMapping("/inserimentoPalette")
    public ResponseEntity<PaletteModel> addNewPalette(@RequestParam("nomePalette")int nomePalette, @RequestParam("email")String email){
        PaletteModel paletteModel=new PaletteModel();
        paletteModel.setIdPalette(nomePalette);

        UtenteModel utenteModel = utenteService.get(email);
        utenteModel.setEmail(email);
        paletteModel.setUtentePalette(utenteModel);

        PaletteModel savedPalette=paletteService.add2(paletteModel,nomePalette,email);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPalette);
    }*/

    /*@PostMapping("/inserimentoColore")
    public ResponseEntity<ColoreModel> addnewColore(@RequestParam("esadecimale")String esadecimale,@RequestParam("nomePalette")int idPalette){
        ColoreModel coloreModel=new ColoreModel();
        coloreModel.setEsadecimale(esadecimale);

        PaletteModel paletteModel=paletteService.get(idPalette);
        paletteModel.setIdPalette(idPalette);
        coloreModel.setPaletteModel(paletteModel);

        ColoreModel saved=coloreService.add2(coloreModel,esadecimale,idPalette);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }*/

    /*@PostMapping("/aggiungi")
    public ResponseEntity<CartellaModel> aggiungiCartella(@RequestBody CartellaModel cartellaModel) {
        CartellaModel nuovaCartella = cartellaService.add(cartellaModel);
        return new ResponseEntity<>(nuovaCartella, HttpStatus.CREATED);
    }*/

    @PostMapping("/mostraEntita")
    public String mostraEntita(Model model, @RequestParam("nomeCartella") String nomeCartella, @RequestParam("email")String email) {
        List<EntitaEntity> entitaList = entitaService.findAllEntity(nomeCartella, email);
        model.addAttribute("entitaList", entitaList);
        return "testDb";
    }

    @PostMapping("/aggiungiEntita")
    public ResponseEntity<EntitaEntity> aggiungientita(@RequestParam("nomeEntita")String nomeEntita,@RequestParam("collisione")String collisione,@RequestParam("coordinate")String coordinate,@RequestParam("nomeFoto") String nomeFoto,@RequestParam("email")String email,@RequestParam("nomeCartella")String nomeCartella,Model model){

        EntitaEntity savedEntitaModel=entitaService.add(nomeEntita,collisione,coordinate,email,nomeFoto,nomeCartella);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntitaModel);
    }

    @PostMapping("/aggiungiEvento")
    public String aggiungiEvento(@RequestParam("nomeEvento")String nome,@RequestParam("email")String email,Model model){
        EventoEntity eventoEntity=eventoService.add(nome,email);
        model.addAttribute("evento",eventoEntity);
        return "testDb";
    }

    @PostMapping("/mostraCartelle")
    public String mostraCartelle(@RequestParam("email")String email,Model model){
        List<CartellaEntity> cartellaEntityList=cartellaService.getAllCartelle(email);
        model.addAttribute("cartellaList",cartellaEntityList);
        return "testDb";
    }

    @PostMapping("aggiungiIstruzione")
    public String aggiungiIstruzione(@RequestParam("nomeIstruzione")String nomeIstruzione,@RequestParam("valoreIstruzione")String valoreIstruzione,@RequestParam("nomeEvento")String nomeEvento,Model model){
        IstruzioneEntity istruzioneEntity=istruzioneService.add(nomeIstruzione,valoreIstruzione,nomeEvento);
        model.addAttribute("istruzione",istruzioneEntity);
        return "testDb";
    }

    @PostMapping("/mostraIstruzioni")
    public String mostraIstruzioni(@RequestParam("nomeEvento")String nomeEvento,Model model){
        List<IstruzioneEntity> istruzioneEntityList=istruzioneService.getAllEntityFromNomeEvento(nomeEvento);
        model.addAttribute("istruzione",istruzioneEntityList);
        return "testDb";
    }

}
