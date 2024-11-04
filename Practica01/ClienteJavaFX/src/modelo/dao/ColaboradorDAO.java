package modelo.dao;

import clientejavafx.utilidades.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import modelo.ConexionWS;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.RespuestaHTTP;

/**
 *
 * @author reyes
 */
public class ColaboradorDAO {

    public static List<Colaborador> obtenerColaboradores() {
        List<Colaborador> colaboradores = null;
        String url = Constantes.URL_WS + "/colaboradores/obtenercolaboradores";
        RespuestaHTTP respuesa = ConexionWS.peticionGET(url);

        if (respuesa.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaColaborador = new TypeToken<List<Colaborador>>() {
                }.getType();
                colaboradores = gson.fromJson(respuesa.getContenido(), tipoListaColaborador);
                System.out.println(colaboradores);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return colaboradores;
    }

    public static Mensaje registrarColaborador(Colaborador colaborador) {
        Mensaje mensaje = new Mensaje();
        String url = Constantes.URL_WS + "/colaboradores/registrarcolaborador";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
            RespuestaHTTP respuesta = ConexionWS.peticionPOSTJSON(url, parametros);
            if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                mensaje = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            } else {
                mensaje.setError(true);
                mensaje.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            mensaje.setError(true);
            mensaje.setMensaje(e.getMessage());
        }
        return mensaje;
    }

    public static Mensaje editarColaborador(Colaborador colaborador) {
        Mensaje mensaje = new Mensaje();
        String url = Constantes.URL_WS + "/colaboradores/editarcolaborador";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
            RespuestaHTTP respuesta = ConexionWS.peticionPUTJSON(url, parametros);
            if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                mensaje = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            } else {
                mensaje.setError(true);
                mensaje.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            mensaje.setError(true);
            mensaje.setMensaje(e.getMessage());
        }
        return mensaje;
    }

    public static Mensaje eliminarColaborador(Colaborador colaborador) {
        Mensaje mensaje = new Mensaje();
        String url = Constantes.URL_WS + "colaboradores/eliminarcolaborador";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
            RespuestaHTTP respuesta = ConexionWS.peticionDELETE(url, parametros); // Realiza la petición DELETE
            if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                mensaje = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            } else {
                mensaje.setError(true);
                mensaje.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            mensaje.setError(true);
            mensaje.setMensaje(e.getMessage());
        }
        return mensaje;
    }
    
    public static Mensaje eliminarColaborador(int idColaborador) {
    Mensaje mensaje = new Mensaje();
    String url = Constantes.URL_WS + "colaboradores/eliminarcolaborador/";
    try {
        RespuestaHTTP respuesta = ConexionWS.peticionDELETEE(url); // Pasar el token
        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            mensaje = new Gson().fromJson(respuesta.getContenido(), Mensaje.class);
        } else {
            mensaje.setError(true);
            mensaje.setMensaje(respuesta.getContenido());
        }
    } catch (Exception e) {
        mensaje.setError(true);
        mensaje.setMensaje(e.getMessage());
    }
    return mensaje;
}



}
