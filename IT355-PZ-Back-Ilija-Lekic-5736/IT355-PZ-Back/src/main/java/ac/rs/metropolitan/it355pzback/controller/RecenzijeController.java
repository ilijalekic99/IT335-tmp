package ac.rs.metropolitan.it355pzback.controller;

import ac.rs.metropolitan.it355pzback.crud.RecenzijaUpdate;
import ac.rs.metropolitan.it355pzback.entity.Recenzija;
import ac.rs.metropolitan.it355pzback.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RecenzijeController {

    @Autowired
    private RecenzijaService recenzijeService;

    @PostMapping("/recenzije")
    public Recenzija registerRecenzija(@RequestBody Recenzija recenzija) {
        return  recenzijeService.registerRecenzija(recenzija);
    }

    @GetMapping("/getRecenzije")
    public List<Recenzija> getRecenzije() {
        List<Recenzija> recenzije = recenzijeService.getRecenzije();
        return recenzije;
    }

    @DeleteMapping(path = "/deleteRecenziju/{idRecenzija}")
    public String deleteRecenzija(@PathVariable(value = "idRecenzija")Long idRecenzija) {
        boolean deleteRecenzija = recenzijeService.deleteRecenzija(idRecenzija);
        return "Uspesno obrisano";
    }

    @PutMapping(path = "/updateRecenzija")
    public String updateRecenzija(@RequestBody RecenzijaUpdate recenzijaUpdate){
        String id = recenzijeService.updateRecenzija(recenzijaUpdate);
        return id;
    }
}
