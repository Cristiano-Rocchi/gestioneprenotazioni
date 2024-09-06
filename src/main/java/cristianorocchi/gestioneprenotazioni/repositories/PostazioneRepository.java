package cristianorocchi.gestioneprenotazioni.repositories;

import cristianorocchi.gestioneprenotazioni.entities.Postazione;

import cristianorocchi.gestioneprenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificioCitta(TipoPostazione tipo, String citta);


}
