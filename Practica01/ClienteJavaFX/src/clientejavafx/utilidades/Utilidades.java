package clientejavafx.utilidades;

import javafx.scene.control.Alert;

/*
 *
 * @author reyes
 */

public class Utilidades {
    
    public static void mostrarAlertaSimple(String titulo, String contenido, Alert.AlertType tipo){   
        
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.show();
    }
    
}
