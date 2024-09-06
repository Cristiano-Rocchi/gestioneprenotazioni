package cristianorocchi.gestioneprenotazioni.services;

import cristianorocchi.gestioneprenotazioni.entities.Prenotazione;
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
        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    public List<Prenotazione> findPrenotazioniByUtenteAndData(Long utenteId, LocalDate dataPrenotazione) {
        return prenotazioneRepository.findByUtenteIdAndDataPrenotazione(utenteId, dataPrenotazione);
    }


}
