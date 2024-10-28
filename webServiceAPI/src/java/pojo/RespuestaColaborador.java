/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.List;

/**
 *
 * @author reyes
 */
public class RespuestaColaborador {
    private boolean error;
    private String mensaje;
    private List<Colaborador> colaboradores;

    public RespuestaColaborador() {
    }
    

    public RespuestaColaborador(boolean error, String mensaje, List<Colaborador> colaboradores) {
        this.error = error;
        this.mensaje = mensaje;
        this.colaboradores = colaboradores;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public boolean isError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }
    
}
