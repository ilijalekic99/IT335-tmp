package ac.rs.metropolitan.it355pzback.crud;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RecenzijaUpdate {
    @Id
    private Long idRecenzija;

    private String textRecenzije;

    private Double markRecenzije;

    public RecenzijaUpdate() {
    }

    public RecenzijaUpdate(String textRecenzije, Double markRecenzije) {
        this.textRecenzije = textRecenzije;
        this.markRecenzije = markRecenzije;
    }

    public RecenzijaUpdate(Long idRecenzija, String textRecenzije, Double markRecenzije) {
        this.idRecenzija = idRecenzija;
        this.textRecenzije = textRecenzije;
        this.markRecenzije = markRecenzije;
    }

    public Long getIdRecenzija() {
        return idRecenzija;
    }

    public void setIdRecenzija(Long idRecenzija) {
        this.idRecenzija = idRecenzija;
    }

    public String getTextRecenzije() {
        return textRecenzije;
    }

    public void setTextRecenzije(String textRecenzije) {
        this.textRecenzije = textRecenzije;
    }

    public Double getMarkRecenzije() {
        return markRecenzije;
    }

    public void setMarkRecenzije(Double markRecenzije) {
        this.markRecenzije = markRecenzije;
    }
}

