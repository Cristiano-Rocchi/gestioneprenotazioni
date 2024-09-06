package cristianorocchi.gestioneprenotazioni.services;

import cristianorocchi.gestioneprenotazioni.entities.Prenotazione;
import cristianorocchi.gestioneprenotazioni.entities.Postazione;
import cristianorocchi.gestioneprenotazioni.entities.Utente;
import cristianorocchi.gestioneprenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id).orElse(null);
    }

    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        // Verifica se l'utente ha già una prenotazione per la stessa data
        List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteIdAndDataPrenotazione(prenotazione.getUtente().getId(), prenotazione.getDataPrenotazione());
        if (!prenotazioniUtente.isEmpty()) {
            throw new IllegalArgumentException("L'utente ha già una prenotazione per questa data.");
        }

        // Verifica se la postazione è libera per quella data
        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazioneAndDataPrenotazione(prenotazione.getPostazione(), prenotazione.getDataPrenotazione());
        if (!prenotazioniPostazione.isEmpty()) {
            throw new IllegalArgumentException("La postazione non è libera per questa data.");
        }

        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    public List<Prenotazione> findPrenotazioniByUtenteAndData(Long utenteId, LocalDate dataPrenotazione) {
        return prenotazioneRepository.findByUtenteIdAndDataPrenotazione(utenteId, dataPrenotazione);
    }
}
