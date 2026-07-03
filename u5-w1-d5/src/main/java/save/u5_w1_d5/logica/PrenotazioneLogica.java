package save.u5_w1_d5.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import save.u5_w1_d5.entities.*;
import save.u5_w1_d5.repository.PrenotazioneRepository;
import java.time.LocalDate;

@Service
public class PrenotazioneLogica {
    @Autowired private PrenotazioneRepository repo;

    public void prenota(Utente utente, Postazione postazione, LocalDate data) {
        try {
            if (repo.existsByUtenteAndDataPrenotazione(utente, data)) {
                System.out.println("Errore: L'utente ha già una prenotazione.");
                return;
            }
            if (repo.existsByPostazioneAndDataPrenotazione(postazione, data)) {
                System.out.println("Errore: postazione già occupata");
                return;
            }
            repo.save(new Prenotazione(utente, postazione, data));
            System.out.println("Prenotazione salvata con successo!");
        } catch (DataAccessException ex) {
            System.err.println("Errore: " + ex.getMessage());
        }
    }
}