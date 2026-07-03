package save.u5_w1_d5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import save.u5_w1_d5.entities.*;
import save.u5_w1_d5.logica.*;

import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired private EdificioLogica edificioLogica;
    @Autowired private PostazioneLogica postazioneLogica;
    @Autowired private UtenteLogica utenteLogica;
    @Autowired private PrenotazioneLogica prenotazioneLogica;

    @Override
    public void run(String... args) throws Exception {

        Edificio e1 = new Edificio("Sede Principale", "Via Ghittoni 105", "Piacenza");
        edificioLogica.salva(e1);



        Postazione p1 = new Postazione("Ufficio1", "Ufficio1", TipoPostazione.UFFICIO, 5, e1);
        postazioneLogica.salva(p1);

        Utente u1 = new Utente("White", "Saverio Casabianca", "esempio@2222.it");
        utenteLogica.salva(u1);

        // Prenotazione
        LocalDate domani = LocalDate.now().plusDays(1);
        prenotazioneLogica.prenota(u1, p1, domani);

        // Proviamo a fare una seconda prenotazione (ERRORE)
        prenotazioneLogica.prenota(u1, p1, domani);

        List<Postazione> ufficiMilano = postazioneLogica.cercaPostazione(TipoPostazione.UFFICIO, "Piacenza");
        System.out.println("Postazioni trovate: " + ufficiMilano.size());

        System.out.println("Tutto funziona!");
    }
}