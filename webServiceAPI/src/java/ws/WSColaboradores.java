/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dominio.ImpColaborador;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.RespuestaColaborador;

@Path("colaboradores")
public class WSColaboradores {

    @Context
    private UriInfo context;

    public WSColaboradores() {
    }

    @Path("obtenercolaboradores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> obtenerColaboradores() {
        List<Colaborador> listaColaboradores = ImpColaborador.obtenerColaboradores();

        if (listaColaboradores != null && !listaColaboradores.isEmpty()) {
            return listaColaboradores;
        } else {
            throw new NotFoundException("No se encontraron colaboradores.");
        }
    }

    @Path("obtenerColaboradorNoPersonal/{noPersonal}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaColaborador getColaborador(@PathParam("noPersonal") String noPersonal) {
        if (!noPersonal.isEmpty()) {
            return ImpColaborador.obtenerColaboradorPorNumero(noPersonal);
        }
        throw new BadRequestException();
    }

    @Path("registrarcolaborador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje registrarColaborador(String jsonColaborador) {
        try {
            Gson gson = new Gson();
            Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
            return ImpColaborador.registrarColaborador(colaborador);
        } catch (Exception e) {
            e.printStackTrace();    //Linea para conocer los errores
            throw new BadRequestException();
        }

    }

    @Path("editarcolaborador")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarColaborador(String jsonColaborador) {
        try {
            Gson gson = new Gson();
            Colaborador colaborador = gson.fromJson(jsonColaborador, Colaborador.class);
            return ImpColaborador.editarColaborador(colaborador);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException();
        }
    }

    @Path("eliminarcolaborador/{noPersonal}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarColaborador(@PathParam("noPersonal") String noPersonal) {
        try {
            return ImpColaborador.eliminarColaborador(noPersonal);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("Error al intentar eliminar el colaborador");
        }
    }

}
