package cristianorocchi.gestioneprenotazioni.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Prenotazione")

@Setter
@ToString
@NoArgsConstructor
public class Prenotazione {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;


    public Prenotazione(LocalDate dataPrenotazione, Utente utente, Postazione postazione) {
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.postazione = postazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

}



