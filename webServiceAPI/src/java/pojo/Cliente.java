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
public class Cliente {
    
    private Integer idCliente;
    private String Nombre;
    private String apellidoP;
    private String apellidoM;
    private String fechaN;
    private String telefono;
    private float peso;
    private Integer estatura;
    private String correo;
    private String contrasena;
    private Integer idRol;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String Nombre, String apellidoP, String apellidoM, String fechaN, String telefono, float peso, Integer estatura, String correo, String contrasena, Integer idRol) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaN = fechaN;
        this.telefono = telefono;
        this.peso = peso;
        this.estatura = estatura;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idRol = idRol;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    
    
}
