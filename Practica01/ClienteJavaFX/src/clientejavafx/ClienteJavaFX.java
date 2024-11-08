package clientejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClienteJavaFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Trae la vista y la transforma en un objeto, ya que en el FXML no se puede manejar objetos
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInicioSesion.fxml"));
        
        Scene scene = new Scene(root);
         
        stage.setScene(scene);
        stage.setTitle("ISO 9001");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
