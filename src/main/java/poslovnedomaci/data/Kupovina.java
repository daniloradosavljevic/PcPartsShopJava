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
public class Kupovina {
    private int kupovina_id;
    private Korisnik korisnik_id;
    private Proizvod proizvod_id;

    public Kupovina(int kupovina_id, Korisnik korisnik_id, Proizvod proizvod_id) {
        this.kupovina_id = kupovina_id;
        this.korisnik_id = korisnik_id;
        this.proizvod_id = proizvod_id;
    }

    public Kupovina(Korisnik korisnik_id, Proizvod proizvod_id) {
        this.korisnik_id = korisnik_id;
        this.proizvod_id = proizvod_id;
    }

    public Kupovina() {
    }
    

    public int getKupovina_id() {
        return kupovina_id;
    }

    public void setKupovina_id(int kupovina_id) {
        this.kupovina_id = kupovina_id;
    }

    public Korisnik getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(Korisnik korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public Proizvod getProizvod_id() {
        return proizvod_id;
    }

    public void setProizvod_id(Proizvod proizvod_id) {
        this.proizvod_id = proizvod_id;
    }

    @Override
    public String toString() {
        return "Kupovina{" + "kupovina_id=" + kupovina_id + ", korisnik_id=" + korisnik_id + ", proizvod_id=" + proizvod_id + '}';
    }
    
}
