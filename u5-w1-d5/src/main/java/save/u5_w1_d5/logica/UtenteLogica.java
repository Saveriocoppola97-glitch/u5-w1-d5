package save.u5_w1_d5.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w1_d5.entities.Utente;
import save.u5_w1_d5.repository.UtenteRepository;

@Service
public class UtenteLogica {
    @Autowired private UtenteRepository repo;

    public void salva(Utente u) {
        repo.save(u);
    }
}