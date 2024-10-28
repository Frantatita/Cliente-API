/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dominio.ImpLogin;
import java.util.HashMap;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import mybatis.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.LoginColaborador;

@Path("login")
public class WSLogin {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSLogin
     */
    public WSLogin() {
    }   

    @Path("colaborador")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public LoginColaborador iniciarSesionColaborador(@FormParam("numeroP") String numeroP, @FormParam("password") String password) {
        //Prioridades de validacion.
        if ((!numeroP.isEmpty() && !password.isEmpty()) && numeroP.length() <= 10) {
            return ImpLogin.validarSesionColaborador(numeroP, password);
        }
        throw new BadRequestException();
    }

    
    @Path("probarconexion")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean probarConexcion(){
        SqlSession conexion = MybatisUtil.obtencionConexion();
        return (conexion!=null);
    }
    
}

/**
 * Retrieves representation of an instance of ws.WSLogin
 *
 * @return an instance of java.lang.String
 */

/*METODOS DE PRUEBA
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "{\n"
                + "  \"nombre\": \"Juan Pérez\",\n"
                + "  \"edad\": 28,\n"
                + "  \"correo_electronico\": \"juan.perez@example.com\",\n"
                + "  \"direccion\": {\n"
                + "    \"calle\": \"Calle Falsa 123\",\n"
                + "    \"ciudad\": \"Ciudad Ejemplo\",\n"
                + "    \"pais\": \"País de Prueba\"\n"
                + "  },\n"
                + "  \"telefonos\": [\n"
                + "    {\n"
                + "      \"tipo\": \"casa\",\n"
                + "      \"numero\": \"123-456-7890\"\n"
                + "    },\n"
                + "    {\n"
                + "      \"tipo\": \"movil\",\n"
                + "      \"numero\": \"098-765-4321\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"hobbies\": [\"leer\", \"viajar\", \"correr\"]\n"
                + "}";
    }

 */
 /*
    //Peticion get pero con nombre
    @Path("saludo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSaludo() {
        return ("Hola, debes mostrar un saludo");
    }
    
    
    @Path("metodoput")
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        return "Hola Json desde put :3";
    }
    

    @Path("probar-conexion")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean probarConexcion(){
        SqlSession conexion = MybatisUtil.obtencionConexion();
        return (conexion!=null);
    } */
