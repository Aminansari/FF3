package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void displayAlert(String message){
        Stage stage = new Stage();
        stage.setTitle("Error");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        Button button = new Button("OK");
        button.autosize();
        button.setOnAction(e -> stage.close());

        Label label = new Label(message);
        label.autosize();

        VBox layout = new VBox();
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
