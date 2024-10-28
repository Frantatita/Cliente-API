package modelo.dao;

import clientejavafx.utilidades.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import modelo.ConexionWS;
import pojo.Colaborador;
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
                Type tipoListaColaborador = new TypeToken<List<Colaborador>>(){}.getType();
               colaboradores = gson.fromJson(respuesa.getContenido(), tipoListaColaborador);
                System.out.println(colaboradores);
            } catch (Exception ex) {
                ex.printStackTrace();
            }   
        }
        return colaboradores;
    }
}
