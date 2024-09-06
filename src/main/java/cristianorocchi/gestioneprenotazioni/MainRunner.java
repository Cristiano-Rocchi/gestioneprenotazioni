package cristianorocchi.gestioneprenotazioni;

import cristianorocchi.gestioneprenotazioni.entities.*;
import cristianorocchi.gestioneprenotazioni.enums.TipoPostazione;
import cristianorocchi.gestioneprenotazioni.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class MainRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        /* EDIFICI */
        Edificio edificio1 = new Edificio("Edificio A", "Via Roma 1", "Milano");
        Edificio edificio2 = new Edificio("Edificio B", "Via Milano 5", "Torino");
        edificioService.saveEdificio(edificio1);
        edificioService.saveEdificio(edificio2);

        /* POSTAZIONI */
        Postazione postazione1 = new Postazione("Postazione Privata ", TipoPostazione.PRIVATO, 1, edificio1);
        Postazione postazione2 = new Postazione("Postazione Open Space ", TipoPostazione.OPENSPACE, 10, edificio1);
        postazioneService.savePostazione(postazione1);
        postazioneService.savePostazione(postazione2);

        /* UTENTI */
        Utente utente1 = new Utente("RAFA99", "Rafael", "Leao", "Rafa@libero.it");
        Utente utente2 = new Utente("Theo", "Theo", "Hernandez", "Theo@libero.it");
        utenteService.saveUtente(utente1);
        utenteService.saveUtente(utente2);

        /* PRENOTAZIONI */
        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now(), utente1, postazione1);
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.now().plusDays(1), utente2, postazione2);
        prenotazioneService.savePrenotazione(prenotazione1);
        prenotazioneService.savePrenotazione(prenotazione2);

        System.out.println("FUNZIONA!");
    }
}

