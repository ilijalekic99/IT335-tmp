package ac.rs.metropolitan.it355pzback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repertoar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRepertoar;

    private String film;

    private String reziser;

    private String zanr;

    private Integer trajanje;

    private Double ocena;

    private String projekcija;

    private Double cenaKarte;

    public Repertoar() {
    }

    public Repertoar(String film, String reziser, String zanr, Integer trajanje, Double ocena, String projekcija, Double cenaKarte) {
        this.film = film;
        this.reziser = reziser;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
        this.projekcija = projekcija;
        this.cenaKarte = cenaKarte;
    }

    public Repertoar(Long idRepertoar, String film, String reziser, String zanr, Integer trajanje, Double ocena, String projekcija, Double cenaKarte) {
        this.idRepertoar = idRepertoar;
        this.film = film;
        this.reziser = reziser;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
        this.projekcija = projekcija;
        this.cenaKarte = cenaKarte;
    }

    public Long getIdRepertoar() {
        return idRepertoar;
    }

    public void setIdRepertoar(Long idRepertoar) {
        this.idRepertoar = idRepertoar;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public String getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(String projekcija) {
        this.projekcija = projekcija;
    }

    public Double getCenaKarte() {
        return cenaKarte;
    }

    public void setCenaKarte(Double cenaKarte) {
        this.cenaKarte = cenaKarte;
    }
}
