/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import poslovnedomaci.dao.ProizvodDao;
import poslovnedomaci.dao.ResourcesManager;
import poslovnedomaci.data.Pretraga;
import poslovnedomaci.data.Proizvod;
import poslovnedomaci.exception.DomaciException;

/**
 *
 * @author Coda
 */
public class ProizvodService {
    private static final ProizvodService instance = new ProizvodService();

    private ProizvodService() {
    }

    public static ProizvodService getInstance() {
        return instance;
    }
    
    public List<Proizvod> findProducts(Pretraga pretraga) throws DomaciException {
    return ProizvodDao.getInstance().findProducts(pretraga);
}

    
    public Proizvod find(int id) throws DomaciException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();

            return ProizvodDao.getInstance().find(id, con);
        } catch (SQLException ex) {
            throw new DomaciException("Failed to find product with id " + id, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }
}
