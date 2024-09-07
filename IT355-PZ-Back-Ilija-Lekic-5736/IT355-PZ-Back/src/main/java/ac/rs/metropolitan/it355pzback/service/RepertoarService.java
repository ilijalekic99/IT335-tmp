package ac.rs.metropolitan.it355pzback.service;

import ac.rs.metropolitan.it355pzback.crud.RecenzijaUpdate;
import ac.rs.metropolitan.it355pzback.crud.RepertoarUpdate;
import ac.rs.metropolitan.it355pzback.entity.Recenzija;
import ac.rs.metropolitan.it355pzback.entity.Repertoar;
import ac.rs.metropolitan.it355pzback.repository.RepertoarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepertoarService {

    @Autowired
    private RepertoarRepository repertoarRepository;

    public Repertoar registerRepertoar(Repertoar repertoar) {

        return repertoarRepository.save(repertoar);
    }

    public List<Repertoar> getRepertoare() {
        List<Repertoar> repertoari = repertoarRepository.findAll();
        return  repertoari;
    }

    public boolean deleteRepertoar(Long idRepertoara) {
        if(repertoarRepository.existsById(idRepertoara)){
            repertoarRepository.deleteById(idRepertoara);
        }else {
            System.out.println("Nismo pronasli ni jedan repertoar sa tim id-jem!");
        }
        return true;
    }

    public String updateRepertoar(RepertoarUpdate repertoarUpdate) {
        Optional<Repertoar> optionalRepertoar = repertoarRepository.findById(repertoarUpdate.getIdRepertoar());
        if (optionalRepertoar.isPresent()) {
            Repertoar repertoar = optionalRepertoar.get();
            repertoar.setFilm(repertoarUpdate.getFilm());
            repertoar.setReziser(repertoarUpdate.getReziser());
            repertoar.setZanr(repertoarUpdate.getZanr());
            repertoar.setTrajanje(repertoarUpdate.getTrajanje());
            repertoar.setOcena(repertoarUpdate.getOcena());
            repertoar.setProjekcija(repertoarUpdate.getProjekcija());
            repertoar.setCenaKarte(repertoarUpdate.getCenaKarte());
            repertoarRepository.save(repertoar);
        } else {
            System.out.println("Tvoja repertoar ne postoji!");
        }
        return null;
    }
}
