/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.data;

/**
 *
 * @author Coda
 */
public class Proizvod {
    private int proizvod_id;
    private String naziv;
    private int cena;
    private String vrsta_opreme;
    private int stanje_na_lageru;

    public Proizvod(int proizvod_id, String naziv, int cena, String vrsta_opreme, int stanje_na_lageru) {
        this.proizvod_id = proizvod_id;
        this.naziv = naziv;
        this.cena = cena;
        this.vrsta_opreme = vrsta_opreme;
        this.stanje_na_lageru = stanje_na_lageru;
    }

    public Proizvod(String naziv, int cena, String vrsta_opreme, int stanje_na_lageru) {
        this.naziv = naziv;
        this.cena = cena;
        this.vrsta_opreme = vrsta_opreme;
        this.stanje_na_lageru = stanje_na_lageru;
    }

    public Proizvod() {
    }
    

    public int getProizvod_id() {
        return proizvod_id;
    }

    public void setProizvod_id(int proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getVrsta_opreme() {
        return vrsta_opreme;
    }

    public void setVrsta_opreme(String vrsta_opreme) {
        this.vrsta_opreme = vrsta_opreme;
    }

    public int getStanje_na_lageru() {
        return stanje_na_lageru;
    }

    public void setStanje_na_lageru(int stanje_na_lageru) {
        this.stanje_na_lageru = stanje_na_lageru;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "proizvod_id=" + proizvod_id + ", naziv=" + naziv + ", cena=" + cena + ", vrsta_opreme=" + vrsta_opreme + ", stanje_na_lageru=" + stanje_na_lageru + '}';
    }
    
    
}
