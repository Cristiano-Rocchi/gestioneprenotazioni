package cristianorocchi.gestioneprenotazioni.repositories;

import cristianorocchi.gestioneprenotazioni.entities.Prenotazione;
import cristianorocchi.gestioneprenotazioni.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteIdAndDataPrenotazione(Long utenteId, LocalDate dataPrenotazione);
    List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}



