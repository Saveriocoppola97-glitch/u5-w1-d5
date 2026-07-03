package save.u5_w1_d5.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import save.u5_w1_d5.entities.Postazione;
import save.u5_w1_d5.entities.TipoPostazione;
import save.u5_w1_d5.repository.PostazioneRepository;
import java.util.List;

@Service
public class PostazioneLogica {
    @Autowired
    private PostazioneRepository repo;

    public void salva(Postazione p) {
        repo.save(p);
    }

    public List<Postazione> cercaPostazione(TipoPostazione tipo, String citta) {
        return repo.findByTipoAndEdificioCitta(tipo, citta);
    }
}