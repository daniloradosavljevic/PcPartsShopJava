/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import poslovnedomaci.dao.KorisnikDao;
import poslovnedomaci.dao.KupovinaDao;
import poslovnedomaci.dao.ProizvodDao;
import poslovnedomaci.dao.ResourcesManager;
import poslovnedomaci.data.Korisnik;
import poslovnedomaci.data.Proizvod;
import poslovnedomaci.exception.DomaciException;

/**
 *
 * @author Coda
 */
public class KupovinaService {
    private static final KupovinaService instance = new KupovinaService();

    private KupovinaService() {
    }

    public static KupovinaService getInstance() {
        return instance;
    }
    
     public void buy(Korisnik korisnik, Proizvod proizvod) throws DomaciException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            
            //more than one SQL statement to execute, needs to be a single transaction
            con.setAutoCommit(false);
             if (proizvod.getStanje_na_lageru() == 0) {
                throw new DomaciException("Nema vise " + proizvod.getNaziv() + " u prodavnici.");
            }

            if (korisnik.getStanje_racuna() < proizvod.getCena()) {
                throw new DomaciException("Korisnik nema dovoljno sredstava za kupovinu: " + korisnik.getStanje_racuna() + ", a cena proizvoda je " + proizvod.getCena());
            }
            
            int novoStanje = korisnik.getStanje_racuna() - proizvod.getCena();
            int novoPotroseno = korisnik.getKolicina_potrosenog_novca() + proizvod.getCena();
            
            korisnik.setStanje_racuna(novoStanje);
            korisnik.setKolicina_potrosenog_novca(novoPotroseno);
            KorisnikDao.getInstance().update(korisnik, con);

            proizvod.setStanje_na_lageru(proizvod.getStanje_na_lageru() - 1);
            ProizvodDao.getInstance().update(proizvod, con);
            
            KupovinaDao.getInstance().buy(korisnik, proizvod,con);
            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new DomaciException("Neuspesna kupovina od strane " + korisnik, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }
     
    public Map<String, Object> prepareData(String username, int id) throws DomaciException {
    Connection con = null;
    try {
        Korisnik korisnik;
        Proizvod proizvod;
        con = ResourcesManager.getConnection();

        korisnik = KorisnikDao.getInstance().find(username, con);
        proizvod = ProizvodDao.getInstance().find(id, con);
        if (korisnik == null) {
    throw new DomaciException("Korisnik sa username-om " + username + " nije pronađen.Proizvod je " + id);
}
if (proizvod == null) {
    throw new DomaciException("Proizvod sa ID-jem " + id + " nije pronađen.");
}

        Map<String, Object> result = new HashMap<>();
        result.put("korisnik", korisnik);
        result.put("proizvod", proizvod);

        return result; 
    } catch (SQLException ex) {
        ResourcesManager.rollbackTransactions(con);
        throw new DomaciException("Failed to fetch korisnik and proizvod", ex);
    } finally {
        ResourcesManager.closeConnection(con);
    }
}
}
