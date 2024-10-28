/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import pojo.Cliente;
import org.apache.ibatis.session.SqlSession;


/**
 *
 * @author reyes
 */
public class ImpCliente {
    
     // Método para obtener todos los clientes
    public static List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = null;
        SqlSession conexionBD = mybatis.MybatisUtil.obtencionConexion();

        if (conexionBD != null) {
            try {
                // Consulta para obtener todos los clientes
                listaClientes = conexionBD.selectList("clientes.ObtenerTodosLosClientes");
            } catch (Exception e) {
                System.err.println("Error al obtener la lista de clientes: " + e.getMessage());
            } finally {
                // Cerrar la sesión para liberar recursos
                conexionBD.close();
            }
        } else {
            System.err.println("Por el momento no se puede consultar la información");
        }

        return listaClientes;
    }

    // Método para obtener un cliente por su correo
    public static Cliente obtenerClientePorCorreo(String correo) {
        Cliente cliente = null;
        SqlSession conexionBD = mybatis.MybatisUtil.obtencionConexion();

        if (conexionBD != null) {
            try {
                HashMap<String, String> parametros = new LinkedHashMap<>();
                parametros.put("correo", correo);
                // Consulta para obtener el cliente por correo
                cliente = conexionBD.selectOne("clientes.ObtenerClientePorCorreo", parametros);
            } catch (Exception e) {
                System.err.println("Error al obtener el cliente por correo: " + e.getMessage());
            } finally {
                // Cerrar la sesión para liberar recursos
                conexionBD.close();
            }
        } else {
            System.err.println("Por el momento no se puede consultar la información");
        }

        return cliente;
    }
    
}
