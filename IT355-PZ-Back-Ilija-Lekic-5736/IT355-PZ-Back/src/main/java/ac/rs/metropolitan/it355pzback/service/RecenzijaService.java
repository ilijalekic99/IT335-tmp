package ac.rs.metropolitan.it355pzback.service;

import ac.rs.metropolitan.it355pzback.crud.RecenzijaUpdate;
import ac.rs.metropolitan.it355pzback.entity.Recenzija;
import ac.rs.metropolitan.it355pzback.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public Recenzija registerRecenzija(Recenzija recenzija) {

        return recenzijaRepository.save(recenzija);
    }

    public List<Recenzija> getRecenzije() {
        List<Recenzija> recenzije = recenzijaRepository.findAll();
        return recenzije;
    }

    public boolean deleteRecenzija(Long idRecenzija) {
        if (recenzijaRepository.existsById(idRecenzija)) {
            recenzijaRepository.deleteById(idRecenzija);
        } else {
            System.out.println("Nismo pronasli ni jendu recenziju sa tim id-jem!");
        }
        return true;
    }

    public String updateRecenzija(RecenzijaUpdate recenzijaUpdate) {
        Optional<Recenzija> optionalRecenzija = recenzijaRepository.findById(recenzijaUpdate.getIdRecenzija());
        if (optionalRecenzija.isPresent()) {
            Recenzija recenzija = optionalRecenzija.get();
            recenzija.setTextRecenzije(recenzijaUpdate.getTextRecenzije());
            recenzija.setMarkRecenzije(recenzijaUpdate.getMarkRecenzije());
            recenzijaRepository.save(recenzija);
        } else {
            System.out.println("Tvoja recenzija ne postoji!");
        }
        return null;
    }
}