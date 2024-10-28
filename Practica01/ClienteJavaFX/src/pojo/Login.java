/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author reyes
 */
public class Login {
     private boolean error;
    private String mensaje;
    private Colaborador colaborador;

    public Login(boolean error, String mensaje, Colaborador colaborador) {
        this.error = error;
        this.mensaje = mensaje;
        this.colaborador = colaborador;
    }

    public Login() {
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }
    
}
