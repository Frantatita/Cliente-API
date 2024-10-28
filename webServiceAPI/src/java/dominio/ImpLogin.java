package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;
import pojo.LoginColaborador;

/**
 *
 * @author reyes
 */
public class ImpLogin {
    
     public static LoginColaborador validarSesionColaborador(String numeroP, String password){
        LoginColaborador respuesta = new LoginColaborador();
        SqlSession conexionBD = mybatis.MybatisUtil.obtencionConexion();
        if(conexionBD!=null){
            try{
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("noPersonal", numeroP);
                parametros.put("password", password);
                Colaborador colaborador = conexionBD.selectOne("sesion.loginColaborador",parametros);
                if(colaborador!=null){
                    respuesta.setError(false);
                    respuesta.setMensaje("Credenciales correctas del colaborador: " + colaborador.getNombre());
                    respuesta.setColaborador(colaborador);
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("No. de personal y/o password incorrectos");
                }
            }catch(Exception e){
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        }else{
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede consultar la informacion");
        }
        
        
        return respuesta;
    }
     
     
     

    
    /*
    public static HashMap <String,Object> validarSesionColaborador(String numeroP, String password){
        HashMap <String, Object> respuesta = new LinkedHashMap<>();
        SqlSession conexionBD = mybatis.MybatisUtil.obtencionConexion();
        if(conexionBD!=null){
            try{
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("noPersonal", "password");
                Colaborador colaborador = conexionBD.selectOne("sesion.LoginColaborador",parametros);
                if(colaborador!=null){
                    respuesta.put("error", false);
                    respuesta.put("mensaje", "Credenciales correctas del colaborador: " + colaborador.getNombre());
                    respuesta.put("colaborador", colaborador);
                }else{
                    respuesta.put("error",true);
                    respuesta.put("mensaje", "No. de personal y/o password incorrectos");
                }
            }catch(Exception e){
                respuesta.put("error", true);
                respuesta.put("mensaje", e.getMessage());
            }
        }else{
            respuesta.put("error", true);
            respuesta.put("mensaje", "Por el momento no se puede consultar la informacion");
        }
        
        
        return respuesta;
    } */
}
