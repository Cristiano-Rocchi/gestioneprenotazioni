package cristianorocchi.gestioneprenotazioni.entities;

import cristianorocchi.gestioneprenotazioni.enums.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


import jakarta.persistence.*;

@Entity
@Table(name = "Postazione")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Postazione {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int numeroMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int numeroMaxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.edificio = edificio;
    }
}

