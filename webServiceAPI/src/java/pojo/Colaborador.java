package pojo;

/**
 *
 * @author reyes
 */
public class Colaborador {
    
    private Integer idColaborador;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String noPersonal;
    private String telefono;
    private String correo;
    private String rfc;
    private String curp;
    private String password;
    private Integer idRol;
    private String Rol;

    public Colaborador() {
    }

    public Colaborador(Integer idColaborador, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String noPersonal, String telefono, String correo, String rfc, String curp, String password, Integer idRol, String Rol) {
        this.idColaborador = idColaborador;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.noPersonal = noPersonal;
        this.telefono = telefono;
        this.correo = correo;
        this.rfc = rfc;
        this.curp = curp;
        this.password = password;
        this.idRol = idRol;
        this.Rol = Rol;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNoPersonal() {
        return noPersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRfc() {
        return rfc;
    }

    public String getCurp() {
        return curp;
    }

    public String getPassword() {
        return password;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public String getRol() {
        return Rol;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNoPersonal(String noPersonal) {
        this.noPersonal = noPersonal;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

   

    
    
    
}
