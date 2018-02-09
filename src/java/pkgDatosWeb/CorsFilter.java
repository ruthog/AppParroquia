/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatosWeb;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Usuario
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        //response.getHeaders().putSingle("Access-Control-Allow-Origin", "http://127.0.0.1:4200");
        //response.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:8383");
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:4200");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Authorization");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.getHeaders().putSingle("Allow", "GET, POST, OPTIONS, PUT, DELETE");
        
        //response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");        
        //// response.getHeaders().putSingle("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        //response.getHeaders().putSingle("Access-Control-Allow-Headers", "Overwrite, Destination, Content-Type, Depth, User-Agent, Translate, Range, Content-Range, Timeout, X-File-Size, X-Requested-With, If-Modified-Since, X-File-Name, Cache-Control, Location, Lock-Token, If");
        //response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        //response.getHeaders().putSingle("Access-Control-Max-Age", "3600");
    }
    
}
