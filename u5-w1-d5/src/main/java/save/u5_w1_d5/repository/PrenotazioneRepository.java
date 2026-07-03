package save.u5_w1_d5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import save.u5_w1_d5.entities.*;
import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data);
}