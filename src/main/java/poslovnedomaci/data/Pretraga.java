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
public class Pretraga {
   private int pretraga_id;
   private Korisnik korisnik_id;
   private PodesavanjePretrage podesavanje_pretrage_id;

    public Pretraga(int pretraga_id, Korisnik korisnik_id, PodesavanjePretrage podesavanje_pretrage_id) {
        this.pretraga_id = pretraga_id;
        this.korisnik_id = korisnik_id;
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
    }

    public Pretraga(Korisnik korisnik_id, PodesavanjePretrage podesavanje_pretrage_id) {
        this.korisnik_id = korisnik_id;
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
    }

    public Pretraga() {
    }

    public int getPretraga_id() {
        return pretraga_id;
    }

    public void setPretraga_id(int pretraga_id) {
        this.pretraga_id = pretraga_id;
    }

    public Korisnik getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(Korisnik korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public PodesavanjePretrage getPodesavanje_pretrage_id() {
        return podesavanje_pretrage_id;
    }

    public void setPodesavanje_pretrage_id(PodesavanjePretrage podesavanje_pretrage_id) {
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
    }

    @Override
    public String toString() {
        return "Pretraga{" + "pretraga_id=" + pretraga_id + ", korisnik_id=" + korisnik_id + ", podesavanje_pretrage_id=" + podesavanje_pretrage_id + '}';
    }
}
