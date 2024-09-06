package cristianorocchi.gestioneprenotazioni.services;

import cristianorocchi.gestioneprenotazioni.entities.Postazione;

import cristianorocchi.gestioneprenotazioni.enums.TipoPostazione;
import cristianorocchi.gestioneprenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> getAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public Postazione getPostazioneById(Long id) {
        return postazioneRepository.findById(id).orElse(null);
    }

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public void deletePostazione(Long id) {
        postazioneRepository.deleteById(id);
    }

    public List<Postazione> findPostazioniByTipoAndCitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificioCitta(tipo, citta);
    }


}
