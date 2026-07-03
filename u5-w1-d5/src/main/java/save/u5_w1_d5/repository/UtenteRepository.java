package save.u5_w1_d5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import save.u5_w1_d5.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}