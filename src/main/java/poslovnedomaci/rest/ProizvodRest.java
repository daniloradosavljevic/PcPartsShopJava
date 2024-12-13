/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.rest;

import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static jdk.nashorn.internal.runtime.Debug.id;
import poslovnedomaci.data.Pretraga;
import poslovnedomaci.data.Proizvod;
import poslovnedomaci.exception.DomaciException;
import poslovnedomaci.service.ProizvodService;

/**
 *
 * @author Coda
 */
@Path("proizvod")
public class ProizvodRest {

    private static final ProizvodService instance = ProizvodService.getInstance();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proizvod> findProducts(Pretraga pretraga) throws DomaciException {
    return ProizvodService.getInstance().findProducts(pretraga);
}
    
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proizvod find(@PathParam("id") int id) throws DomaciException {
        return ProizvodService.getInstance().find(id);
    }
    
}
