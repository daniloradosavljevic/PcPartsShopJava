/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnedomaci.rest;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import poslovnedomaci.dao.KorisnikDao;
import poslovnedomaci.data.Korisnik;
import poslovnedomaci.data.Proizvod;
import poslovnedomaci.exception.DomaciException;
import poslovnedomaci.service.KorisnikService;
import poslovnedomaci.service.KupovinaService;
import poslovnedomaci.service.ProizvodService;

/**
 *
 * @author Coda
 */
@Path("kupovina")
public class KupovinaRest {
     private static final KupovinaService instance = KupovinaService.getInstance();
     
   @POST
    @Path("buy")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buyProduct(@QueryParam("username") String username, @QueryParam("id") int id) {
        try {
            Map<String, Object> preparedData = KupovinaService.getInstance().prepareData(username, id);

            Korisnik korisnik = (Korisnik) preparedData.get("korisnik");
            Proizvod proizvod = (Proizvod) preparedData.get("proizvod");
            
            System.out.println(korisnik);
            System.out.println(proizvod);
            KupovinaService.getInstance().buy(korisnik, proizvod);

            return Response.ok("Purchase successful").build();
        } catch (DomaciException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error during purchase: " + e.getMessage())
                           .build();
        }
    }

    
}
