/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.RespuestaColaborador;

/**
 *
 * @author reyes
 */
public class ImpColaborador {

    public static List<Colaborador> obtenerColaboradores() {

        List<Colaborador> listaColaboradores = new ArrayList<>();
        SqlSession conexionBD = mybatis.MybatisUtil.obtencionConexion();

        if (conexionBD != null) {
            try {
                listaColaboradores = conexionBD.selectList("colaborador.getColaboradores");
            } catch (Exception e) {
                // Manejo de excepciones si ocurre un error al recuperar los colaboradores
                System.err.println("Error al recuperar los colaboradores: " + e.getMessage());
            } finally {
                // Cerrar la sesión para liberar recursos
                conexionBD.close();
            }
        } else {
            System.err.println("Por el momento no se puede consultar la información");
        }

        return listaColaboradores;
    }

    public static RespuestaColaborador obtenerColaboradorPorNumero(String noPersonal) {
        RespuestaColaborador respuesta = new RespuestaColaborador();
        SqlSession conexionBD = mybatis.MybatisUtil.obtencionConexion();
        if (conexionBD != null) {
            try {
                ArrayList<Colaborador> lista = new ArrayList<>();
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("noPersonal", noPersonal);
                Colaborador colaborador = conexionBD.selectOne("colaborador.getColaboradorPorNoPersonal", parametros);
                if (colaborador != null) {
                    lista.add(colaborador);
                    respuesta.setColaboradores(lista);
                    respuesta.setError(false);
                    respuesta.setMensaje("Se encontro el colaborador");
                } else {
                    respuesta.setError(true);
                    respuesta.setMensaje("Error numero Personal del colaborador incorrecto");
                }
            } catch (Exception e) {
                respuesta.setError(true);
                respuesta.setMensaje(e.getMessage());
            }
        } else {
            respuesta.setError(true);
            respuesta.setMensaje("Por el momento no se puede consultar la información.");
        }

        return respuesta;
    }

    public static Mensaje registrarColaborador(Colaborador colaborador) {

        Mensaje mensaje = new Mensaje();
        SqlSession conexionDB = mybatis.MybatisUtil.obtencionConexion();

        if (conexionDB != null) {
            try {
                int resultado = conexionDB.insert("colaborador.registrar", colaborador);
                conexionDB.commit();
                if (resultado > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Colaborador(a) registrado con exito");
                } else {
                    mensaje.setError(true);
                    mensaje.setMensaje("No se pudo registrar al colaborador(as)");
                }
            } catch (Exception e) {
                mensaje.setMensaje(e.getMessage());
            }
        } else {
            mensaje.setError(true);
            mensaje.setMensaje("Por el momento el servicio no esta disponible");
        }
        return mensaje;
    }

    public static Mensaje editarColaborador(Colaborador colaborador) {
        Mensaje mensaje = new Mensaje();
        SqlSession conexionDB = mybatis.MybatisUtil.obtencionConexion();

        if (conexionDB != null) {
            try {
                int resultado = conexionDB.update("colaborador.editar", colaborador);
                conexionDB.commit();
                if (resultado > 0) {
                    mensaje.setError(false);
                    mensaje.setMensaje("Colaborador(a) editado con éxito");
                } else {
                    mensaje.setError(true);
                    mensaje.setMensaje("No se pudo editar el colaborador(a)");
                }
            } catch (Exception e) {
                e.printStackTrace();  // Para conocer los detalles del error
                mensaje.setError(true);
                mensaje.setMensaje("Error al editar el colaborador: " + e.getMessage());
            } finally {
                conexionDB.close();
            }
        } else {
            mensaje.setError(true);
            mensaje.setMensaje("Por el momento el servicio no está disponible");
        }

        return mensaje;
    }

    public static Mensaje eliminarColaborador(String noPersonal) {
    Mensaje mensaje = new Mensaje();
    SqlSession conexionDB = mybatis.MybatisUtil.obtencionConexion();

    if (conexionDB != null) {
        try {
            int resultado = conexionDB.delete("colaborador.eliminar", noPersonal);
            conexionDB.commit();
            if (resultado > 0) {
                mensaje.setError(false);
                mensaje.setMensaje("Colaborador eliminado con éxito");
            } else {
                mensaje.setError(true);
                mensaje.setMensaje("No se pudo eliminar el colaborador");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Para conocer los detalles del error
            mensaje.setError(true);
            mensaje.setMensaje("Error al eliminar el colaborador: " + e.getMessage());
        } finally {
            if (conexionDB != null) {
                conexionDB.close(); // Cerrar conexión si existe
            }
        }
    } else {
        mensaje.setError(true);
        mensaje.setMensaje("Por el momento el servicio no está disponible");
    }

    return mensaje;
}

}
