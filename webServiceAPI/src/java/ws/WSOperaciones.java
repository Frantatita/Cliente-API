
package ws;

import Operaciones.ImpOperaciones;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.ResultadoOperacion;


@Path("Operaciones")
public class WSOperaciones {
    
    @Path("sumar/{numero1},{numero2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion sumar(@PathParam("numero1") Integer num1, @PathParam("numero2") Integer num2){
        //TODO Validaciones
        ResultadoOperacion resultado = ImpOperaciones.sumar(num1, num2);
        return resultado;
    }
    
    /*
    @Path("restar/{numero1},{numero2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion resta(@PathParam("numero1") Integer num1, @PathParam("numero2") Integer num2){
        //TODO Validaciones
        ResultadoOperacion resultado = ImpOperaciones.restar(num1, num2);
        return resultado;
    } */
    
    @Path("restar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion resta(@FormParam("numero1") Integer num1, @FormParam("numero2") Integer num2){
        //TODO Validaciones
        ResultadoOperacion resultado = ImpOperaciones.restar(num1, num2);
        return resultado;
    }
    
    
    @Path("multiplicacion/{numero1},{numero2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion multiplicar(@PathParam("numero1") Integer num1, @PathParam("numero2") Integer num2){
        ResultadoOperacion resultado = ImpOperaciones.multiplicar(num1, num2);
        return resultado;
    }
    
    @Path("division/{numero1},{numero2}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultadoOperacion division(@PathParam("numero1") Integer num1, @PathParam("numero2")Integer num2){
        ResultadoOperacion resultado = ImpOperaciones.dividir(num1, num2);
        return resultado;
    }
    
}