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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import poslovnedomaci.data.Pretraga;
import poslovnedomaci.data.Proizvod;
import poslovnedomaci.exception.DomaciException;

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
    
   public List<Proizvod> findProducts(Pretraga pretraga) throws DomaciException {
    List<Proizvod> filtriraniProizvodi = new ArrayList<>();
    StringBuilder sql = new StringBuilder("SELECT * FROM proizvod WHERE 1=1");

    if (pretraga.getDonja_granica_obima_cene() != null && pretraga.getDonja_granica_obima_cene().length > 0) {
        sql.append(" AND cena >= ?");
    }
    if (pretraga.getGornja_granica_obima_cene() != null && pretraga.getGornja_granica_obima_cene().length > 0) {
        sql.append(" AND cena <= ?");
    }
    if (pretraga.getVrsta_opreme() != null && pretraga.getVrsta_opreme().length > 0) {
        sql.append(" AND vrsta_opreme = ?");
    }
    if (pretraga.getKljucna_rec() != null && pretraga.getKljucna_rec().length > 0) {
        sql.append(" AND naziv LIKE ?");
    }

    try (Connection con = ResourcesManager.getConnection();
         PreparedStatement ps = con.prepareStatement(sql.toString())) {

        int paramIndex = 1;
        if (pretraga.getDonja_granica_obima_cene() != null && pretraga.getDonja_granica_obima_cene().length > 0) {
            ps.setInt(paramIndex++, pretraga.getDonja_granica_obima_cene()[0]);  
        }
        if (pretraga.getGornja_granica_obima_cene() != null && pretraga.getGornja_granica_obima_cene().length > 0) {
            ps.setInt(paramIndex++, pretraga.getGornja_granica_obima_cene()[0]); 
        }
        if (pretraga.getVrsta_opreme() != null && pretraga.getVrsta_opreme().length > 0) {
            ps.setString(paramIndex++, pretraga.getVrsta_opreme()[0]);  
        }
        if (pretraga.getKljucna_rec() != null && pretraga.getKljucna_rec().length > 0) {
            ps.setString(paramIndex++, "%" + pretraga.getKljucna_rec()[0] + "%");  
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proizvod proizvod = new Proizvod();
                proizvod.setProizvod_id(rs.getInt("proizvod_id"));
                proizvod.setNaziv(rs.getString("naziv"));
                proizvod.setCena(rs.getInt("cena"));
                proizvod.setVrsta_opreme(rs.getString("vrsta_opreme"));
                proizvod.setStanje_na_lageru(rs.getInt("stanje_na_lageru"));
                filtriraniProizvodi.add(proizvod);
            }
        }
    } catch (SQLException ex) {
        throw new DomaciException("Error while fetching filtered products", ex);
    }
    return filtriraniProizvodi;
}

    
    public Proizvod find(int id, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Proizvod proizvod = null;
        try {
            ps = con.prepareStatement("SELECT * FROM proizvod where proizvod_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                proizvod = new Proizvod(rs.getInt("proizvod_id"), rs.getString("naziv"), rs.getInt("cena"),rs.getString("vrsta_opreme"), rs.getInt("stanje_na_lageru"));
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return proizvod;
    }
}
