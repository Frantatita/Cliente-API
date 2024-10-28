/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpCliente;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pojo.Cliente;

/**
 *
 * @author reyes
 */

@Path("Cliente")
public class WsClientes {
    
    @Context
    private UriInfo context;

    public WsClientes(){
    }
    
    @Path("obtener-clientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = ImpCliente.obtenerClientes();

        if (listaClientes != null && !listaClientes.isEmpty()) {
            return listaClientes; // Retorna la lista de clientes
        } else {
            throw new NotFoundException("No se encontraron clientes.");
        }
    }

    // Método para obtener un cliente por correo electrónico
    @GET
    @Path("cliente-correo/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente obtenerClientePorCorreo(@PathParam("correo") String correo) {
        // Validación del correo
        if (correo == null || correo.isEmpty() || !correo.contains("@")) {
            throw new BadRequestException("Correo electrónico inválido.");
        }

        // Lógica de negocio para obtener el cliente por correo
        Cliente cliente = ImpCliente.obtenerClientePorCorreo(correo);

        // Verifica si el cliente fue encontrado
        if (cliente != null) {
            return cliente; // Retorna el cliente encontrado
        } else {
            throw new NotFoundException("No se encontró ningún cliente con el correo: " + correo);
        }
    }
    
}
