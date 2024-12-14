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
import java.sql.Statement;
import poslovnedomaci.data.Korisnik;
import poslovnedomaci.data.Kupovina;
import poslovnedomaci.data.Proizvod;

/**
 *
 * @author Coda
 */
public class KupovinaDao {

    private static final KupovinaDao instance = new KupovinaDao();

    private KupovinaDao() {
    }

    public static KupovinaDao getInstance() {
        return instance;
    }

    public Kupovina find(int idKupovina, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Kupovina Kupovina = null;
        try {
            ps = con.prepareStatement("SELECT * FROM Kupovina where id_Kupovina=?");
            ps.setInt(1, idKupovina);
            rs = ps.executeQuery();
            if (rs.next()) {
                Korisnik korisnik = KorisnikDao.getInstance().find(rs.getString("fk_korisnik"), con);
                Proizvod proizvod = ProizvodDao.getInstance().find(rs.getInt("fk_proizvod"), con);
                Kupovina = new Kupovina(idKupovina, korisnik, proizvod);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return Kupovina;
    }

    public void buy(Korisnik korisnik, Proizvod proizvod, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int korisnikId=-1;
        ps = con.prepareStatement("SELECT korisnik_id FROM Korisnik WHERE username = ?");
        ps.setString(1, korisnik.getUsername());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            korisnikId = rs.getInt("korisnik_id");
        }
        try {
            if (korisnikId != -1) {
            ps = con.prepareStatement("INSERT INTO Kupovina(korisnik_id, proizvod_id) VALUES(?,?)");
            ps.setInt(1, korisnikId);
            ps.setInt(2, proizvod.getProizvod_id());
            ps.executeUpdate(); 
            }
            else if (korisnikId == -1) {
    throw new SQLException("Korisnik sa username-om " + korisnik.getUsername() + " nije pronađen.");
}

        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
    }
}
