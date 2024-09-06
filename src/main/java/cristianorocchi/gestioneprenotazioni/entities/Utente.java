package cristianorocchi.gestioneprenotazioni.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Utenti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Utente {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String nome;
    private String surname;
    private String email;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nome, String surname, String email) {
        this.username = username;
        this.nome = nome;
        this.surname = surname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public Long getId() {
        return id;
    }
}
