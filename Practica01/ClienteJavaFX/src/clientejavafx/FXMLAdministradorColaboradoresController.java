/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejavafx;

import clientejavafx.utilidades.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.dao.ColaboradorDAO;
import pojo.Colaborador;

/**
 * FXML Controller class
 *
 * @author reyes
 */
public class FXMLAdministradorColaboradoresController implements Initializable {

    private ObservableList<Colaborador> colaboradores;

    @FXML
    private TableView<Colaborador> tablaColaborador;
    @FXML
    private TableColumn colNoPersonal;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private TableColumn colFechaNacimiento;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TextField tfColaborador;
    @FXML
    private Button btnAgregarColaborador;
    @FXML
    private Button btnEliminarColaborador;
    @FXML
    private Button btnEditarColaborador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarTabla();
        cargarInformacionTabla();
    }

    @FXML
    private void agregraColaborador(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXMLFormularioColaboradores.fxml"));
            Stage escenarioForm = new Stage();
            Scene escenaFormulario = new Scene(root);
            escenarioForm.setScene(escenaFormulario);
            escenarioForm.setTitle("Formulario Colaborador");
            escenarioForm.initModality(Modality.APPLICATION_MODAL);
            escenarioForm.showAndWait();
            
        }catch(IOException ex){
            Utilidades.mostrarAlertaSimple("Error", "Lo sentimos", Alert.AlertType.NONE);
        }
    }

    @FXML
    private void eliminarColaborador(ActionEvent event) {
       
    }

    @FXML
    private void editarColaborador(ActionEvent event) {
        
    }

    private void configurarTabla() {
        colNoPersonal.setCellValueFactory(new PropertyValueFactory("noPersonal"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        colTipo.setCellValueFactory(new PropertyValueFactory("Rol"));
    }

    private void cargarInformacionTabla() {
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> listaWS = ColaboradorDAO.obtenerColaboradores();
        if (listaWS != null) {
            colaboradores.addAll(listaWS);
            tablaColaborador.setItems(colaboradores);
        } else {
            Utilidades.mostrarAlertaSimple("ERROR", "Por el momento no podemos acceder a los datos de los"
                    + "colaboradores, intente mas tarde", Alert.AlertType.ERROR);
        }
        //CerrarVentana();
    }

    private void CerrarVentana() {
        
        //Una forma de representar lo mismo
        Stage escenarioActual = (Stage) btnEliminarColaborador.getScene().getWindow();
        escenarioActual.close(); 

       // ((Stage) tfColaborador.getScene().getWindow()).close();
    }

}
