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
import poslovnedomaci.data.Proizvod;

/**
 *
 * @author Coda
 */
public class ProizvodDao {
      private static final ProizvodDao instance = new ProizvodDao();

    private ProizvodDao() {
    }

    public static ProizvodDao getInstance() {
        return instance;
    }
/*
    protected Proizvod find(int proizvod_id, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Proizvod proizvod = null;
        try {
            ps = con.prepareStatement("SELECT * FROM proizvod where proizvod_id=?");
            ps.setInt(1, proizvod_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                proizvod = new Proizvod(rs.getString("naziv"), rs.getInt("cena"), rs.getString("vrsta_opreme",rs.getInt("stanje_na_lageru")));
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return proizvod;
    }

    protected int insert(Proizvod proizvod, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try {
            ps = con.prepareStatement("INSERT INTO proizvod(city, street, street_number) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proizvod.getCity());
            ps.setString(2, proizvod.getStreet());
            ps.setString(3, proizvod.getStreetNumber());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return id;
    }*/
}
