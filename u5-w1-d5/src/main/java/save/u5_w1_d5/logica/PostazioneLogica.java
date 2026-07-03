package save.u5_w1_d5.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import save.u5_w1_d5.entities.Postazione;
import save.u5_w1_d5.entities.TipoPostazione;
import save.u5_w1_d5.repository.PostazioneRepository;
import java.util.List;

@Service
public class PostazioneLogica {
    @Autowired private PostazioneRepository repo;

    public void salva(Postazione p) {
        try {
            repo.save(p);
            System.out.println("Postazione salvata!");
        } catch (DataAccessException ex) {
            System.err.println("Errore nel salvataggio: " + ex.getMessage());
        }
    }

    public List<Postazione> cercaPostazione(TipoPostazione tipo, String citta) {
        try {
            return repo.findByTipoAndEdificioCitta(tipo, citta);
        } catch (DataAccessException ex) {
            System.err.println("Errore X ricerca: " + ex.getMessage());
            return List.of();
        }
    }
}