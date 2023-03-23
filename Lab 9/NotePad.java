package notepad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class NotePad extends Application {

    @Override
    public void start(Stage primaryStage) {

        NotePadFXMLBase root = new NotePadFXMLBase();
        Scene scene = new Scene(root, 600, 500);

        primaryStage.setTitle("NotePad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
