package save.u5_w1_d5.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import save.u5_w1_d5.entities.Edificio;
import save.u5_w1_d5.repository.EdificioRepository;

@Service
public class EdificioLogica {
    @Autowired private EdificioRepository repo;

    public void salva(Edificio e) {
        try {
            repo.save(e);
            System.out.println("Edificio salvato!");
        } catch (DataAccessException ex) {
            System.err.println("Errore nel salvataggio: " + ex.getMessage());
        }
    }
}