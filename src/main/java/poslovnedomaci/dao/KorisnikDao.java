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
    public void register(Korisnik korisnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try {
            ps = con.prepareStatement("INSERT INTO korisnik(ime_i_prezime,username, password, email, datum_rodjenja, stanje_racuna, kolicina_potrosenog_novca) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, korisnik.getIme_i_prezime());
            ps.setString(2, korisnik.getUsername());
            ps.setString(3, korisnik.getPassword());
            ps.setString(4, korisnik.getEmail());
            ps.setString(5, korisnik.getDatum_rodjenja());
            ps.setInt(6, korisnik.getStanje_racuna());
            ps.setInt(7, korisnik.getKolicina_potrosenog_novca());
            ps.executeUpdate();
  
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
    }
    
     public void update(Korisnik korisnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try {
            ps = con.prepareStatement("UPDATE korisnik set stanje_racuna = ? , kolicina_potrosenog_novca = ? WHERE username=?");
            ps.setInt(1, korisnik.getStanje_racuna());
            ps.setInt(2, korisnik.getKolicina_potrosenog_novca());
            ps.setString(3, korisnik.getUsername());
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
    }
    
    public String login(String username, String password, Connection con) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id;
        String ime_i_prezime;
        String full;
        try {
            ps = con.prepareStatement("SELECT korisnik_id, ime_i_prezime FROM korisnik WHERE username =? AND password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
             if (rs.next()) {
                 id = rs.getInt("korisnik_id");
                 ime_i_prezime = rs.getString("ime_i_prezime");
                 full = id + "," + ime_i_prezime;
                 return full;
        } 
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return null;
    }
}
