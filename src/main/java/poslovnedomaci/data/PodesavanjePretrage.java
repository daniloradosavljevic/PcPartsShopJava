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
public class PodesavanjePretrage {
    private int podesavanje_pretrage_id;
    private int donja_granica_obima_cene;
    private int gornja_granica_obima_cene;
    private String kljucna_rec;

    public PodesavanjePretrage(int podesavanje_pretrage_id, int donja_granica_obima_cene, int gornja_granica_obima_cene, String kljucna_rec) {
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
        this.donja_granica_obima_cene = donja_granica_obima_cene;
        this.gornja_granica_obima_cene = gornja_granica_obima_cene;
        this.kljucna_rec = kljucna_rec;
    }

    public PodesavanjePretrage(int donja_granica_obima_cene, int gornja_granica_obima_cene, String kljucna_rec) {
        this.donja_granica_obima_cene = donja_granica_obima_cene;
        this.gornja_granica_obima_cene = gornja_granica_obima_cene;
        this.kljucna_rec = kljucna_rec;
    }

    public PodesavanjePretrage() {
    }
    

    public int getPodesavanje_pretrage_id() {
        return podesavanje_pretrage_id;
    }

    public void setPodesavanje_pretrage_id(int podesavanje_pretrage_id) {
        this.podesavanje_pretrage_id = podesavanje_pretrage_id;
    }

    public int getDonja_granica_obima_cene() {
        return donja_granica_obima_cene;
    }

    public void setDonja_granica_obima_cene(int donja_granica_obima_cene) {
        this.donja_granica_obima_cene = donja_granica_obima_cene;
    }

    public int getGornja_granica_obima_cene() {
        return gornja_granica_obima_cene;
    }

    public void setGornja_granica_obima_cene(int gornja_granica_obima_cene) {
        this.gornja_granica_obima_cene = gornja_granica_obima_cene;
    }

    public String getKljucna_rec() {
        return kljucna_rec;
    }

    public void setKljucna_rec(String kljucna_rec) {
        this.kljucna_rec = kljucna_rec;
    }

    @Override
    public String toString() {
        return "PodesavanjePretrage{" + "podesavanje_pretrage_id=" + podesavanje_pretrage_id + ", donja_granica_obima_cene=" + donja_granica_obima_cene + ", gornja_granica_obima_cene=" + gornja_granica_obima_cene + ", kljucna_rec=" + kljucna_rec + '}';
    }
    
}
