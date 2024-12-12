/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import poslovnedomaci.data.Korisnik;

/**
 *
 * @author Coda
 */
public class KorisnikDao {
    private static final KorisnikDao instance = new KorisnikDao();

    private KorisnikDao() {
    }

    public static KorisnikDao getInstance() {
        return instance;
    }

    public Korisnik find(String username, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Korisnik korisnik = null;
        try {
            ps = con.prepareStatement("SELECT * FROM korisnik where username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                korisnik = new Korisnik(rs.getString("ime_i_prezime"),username,rs.getString("password"),rs.getString("email"),rs.getString("datum_rodjenja"),rs.getInt("stanje_racuna"),rs.getInt("kolicina_potrosenog_novca"));
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return korisnik;
    }
}
