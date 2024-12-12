/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import poslovnedomaci.data.Korisnik;
import poslovnedomaci.exception.DomaciException;
import poslovnedomaci.service.KorisnikService;

/**
 *
 * @author Coda
 */
    @Path("korisnik")
public class KorisnikRest {
    
    private final KorisnikService korisnikService = KorisnikService.getInstance();
    
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Korisnik getKorisnikById(@PathParam("username") String username) throws DomaciException {
        return korisnikService.findKorisnik(username);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addKorisnik(Korisnik korisnik) throws DomaciException{
            //korisnikService.addNewKorisnik(korisnik);
            return Response.ok().build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateClan(Korisnik korisnik) throws DomaciException {
           // korisnikService.updateKorisnik(korisnik);
            return Response.ok().build();
    }
    
    @DELETE
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClan(@PathParam("username") String username) throws DomaciException {
           // korisnikService.deleteKorisnik(username);
            return Response.ok().build();
    }
}

