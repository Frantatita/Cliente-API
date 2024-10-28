/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import clientejavafx.utilidades.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import modelo.ConexionWS;
import pojo.Login;
import pojo.RespuestaHTTP;

/**
 *
 * @author reyes
 */

public class LoginDAO {
    public static Login iniciarSesion(String numP, String password){
        Login respuestaLogin = new Login();
        String url;
        String urlServicio= Constantes.URL_WS + "/login/colaborador";
        String parametros =String.format("numeroP=%s&password=%s", numP, password);
        RespuestaHTTP respustaWS = ConexionWS.peticionPOST(urlServicio, parametros);
        if(respustaWS.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            System.out.println("JSON"+ respustaWS.getContenido());
            Gson gson = new Gson();
            respuestaLogin = gson.fromJson(respustaWS.getContenido(),Login.class);
        }else{
            respuestaLogin.setError(true);
            respuestaLogin.setMensaje("Lo sentimos, hubo un error al procesar la autentificacion");
        }
        return respuestaLogin;
    }
}
