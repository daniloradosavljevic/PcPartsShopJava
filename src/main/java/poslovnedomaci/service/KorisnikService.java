/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.service;

import java.sql.Connection;
import java.sql.SQLException;
import poslovnedomaci.dao.KorisnikDao;
import poslovnedomaci.dao.ResourcesManager;
import poslovnedomaci.data.Korisnik;
import poslovnedomaci.exception.DomaciException;

/**
 *
 * @author Coda
 */
public class KorisnikService {
    
     private static final KorisnikService instance = new KorisnikService();

    private KorisnikService() {
    }

    public static KorisnikService getInstance() {
        return instance;
    }

     public Korisnik findKorisnik(String username) throws DomaciException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();

            return KorisnikDao.getInstance().find(username, con);

        } catch (SQLException ex) {
            throw new DomaciException("Failed to find customer with username " + username, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }
}
