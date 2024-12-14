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
    private Korisnik korisnik;
    private Proizvod proizvod;

    public Kupovina(int kupovina_id, Korisnik korisnik, Proizvod proizvod) {
        this.kupovina_id = kupovina_id;
        this.korisnik = korisnik;
        this.proizvod = proizvod;
    }

    public Kupovina(Korisnik korisnik, Proizvod proizvod) {
        this.korisnik = korisnik;
        this.proizvod = proizvod;
    }

    public Kupovina() {
    }
    

    public int getKupovina_id() {
        return kupovina_id;
    }

    public void setKupovina_id(int kupovina_id) {
        this.kupovina_id = kupovina_id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return "Kupovina{" + "kupovina_id=" + kupovina_id + ", korisnik=" + korisnik + ", proizvod=" + proizvod + '}';
    }

    
    
}
