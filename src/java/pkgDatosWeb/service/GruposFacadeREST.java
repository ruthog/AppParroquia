/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatosWeb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pkgDatosWeb.Grupos;

/*
import com.sun.jersey.api.json.JSONWithPadding;    //Viernes 19
import java.util.Collection;                        //Viernes 19
import javax.ws.rs.QueryParam;                      //Viernes 19
import javax.ws.rs.core.GenericEntity;              //Viernes 19
*/

/**
 *
 * @author Usuario
 */
@Stateless
@Path("pkgdatosweb.grupos")
public class GruposFacadeREST extends AbstractFacade<Grupos> {

    @PersistenceContext(unitName = "AppParroquiaPU")
    private EntityManager em;

    public GruposFacadeREST() {
        super(Grupos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Grupos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Grupos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Grupos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Grupos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Grupos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    //Nueva_Ruth Viernes 19--------------------------------------------------
    /*
    @GET
    @Path("{from}/{to}/jsonp")
    @Produces({"application/javascript"})
    public JSONWithPadding findRangeJsonP(@PathParam("from") Integer from,
            @PathParam("to") Integer to, @QueryParam("callback") String callback) {
        Collection<Grupos> grupos = super.findRange(new int[]{from, to});
        return new JSONWithPadding(new GenericEntity<Collection<Grupos>>(grupos) {
        }, callback);
    }
    */
    //Fin Viernes 19--------------------------------------------------------

    
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
