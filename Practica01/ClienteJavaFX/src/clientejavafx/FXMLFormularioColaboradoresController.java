/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.utilidades.Utilidades;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.dao.ColaboradorDAO;
import pojo.Colaborador;
import pojo.Mensaje;
import pojo.Rol;

/**
 * FXML Controller class
 *
 * @author reyes
 */
public class FXMLFormularioColaboradoresController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private TextField tfNumeroPersonal;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfRfc;
    @FXML
    private TextField tfCurp;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private ComboBox<Rol> cbRol;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CargarTiposUsuarios();
    }

    private void CargarTiposUsuarios() {
        ObservableList<Rol> tiposColaboradores = FXCollections.observableArrayList();
        tiposColaboradores.add(new Rol(1, "Colaborador"));
        tiposColaboradores.add(new Rol(2, "Cliente"));
        cbRol.setItems(tiposColaboradores);
    }

    @FXML
    private void clickGuardarColaborador(ActionEvent event) {

        String noPersonal = tfNumeroPersonal.getText();
        String nommbre = tfNombre.getText();
        String apellidoPaterno = tfApellidoPaterno.getText();
        String apellidoMaterno = tfApellidoMaterno.getText();
        String rfc = tfRfc.getText();
        String correo = tfCorreo.getText();
        String curp = tfCurp.getText();
        String telefono = tfTelefono.getText();
        String password = pfPassword.getText();
        String fechaNacimiento = dpFechaNacimiento.getValue().toString();
        //Operador ternario o expresion condicional ternarioS
        Integer idRol = ((cbRol.getSelectionModel().getSelectedItem() != null)
                ? cbRol.getSelectionModel().getSelectedItem().getIdRol() : null);

        Colaborador colaborador = new Colaborador();
        colaborador.setNoPersonal(noPersonal);
        colaborador.setNombre(nommbre);
        colaborador.setApellidoMaterno(apellidoMaterno);
        colaborador.setApellidoPaterno(apellidoPaterno);
        colaborador.setRfc(rfc);
        colaborador.setCorreo(correo);
        colaborador.setCurp(curp);
        colaborador.setTelefono(telefono);
        colaborador.setPassword(password);
        colaborador.setFechaNacimiento(fechaNacimiento);
        colaborador.setIdRol(idRol);

        if(validarCampos(colaborador)){
            guardarDatosColaborador(colaborador);
        }else{
            Utilidades.mostrarAlertaSimple("Campos obligatorios","Por favor llena todos los campos", Alert.AlertType.WARNING);
        }
        
    }

    private boolean validarCampos(Colaborador colaborador) {

        return true;
    }
  
    
    private void guardarDatosColaborador(Colaborador colaborador){
        Mensaje mensaje = ColaboradorDAO.registrarColaborador(colaborador);
        if(!mensaje.isError()){
            Utilidades.mostrarAlertaSimple("Registro exitoso", "La informacion del colaborador: " 
                    + colaborador.getNombre() + " fue registrado correctamente" , Alert.AlertType.INFORMATION);
            cerrarVentana();
        }else{
            Utilidades.mostrarAlertaSimple("ERROR", mensaje.getMensaje(), Alert.AlertType.ERROR);
        }
        
    }
    
    
    private void cerrarVentana(){
        Stage base = (Stage) tfNombre.getScene().getWindow();
        base.close();
    }
}
