package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean rspn = false;

    public static boolean display(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Exit program");
        stage.setMinWidth(250);
        Button yes = new Button("yes");
        yes.setOnAction(e -> {
            rspn=true;
            stage.close();
        });
        Button no = new Button("no");
        no.setOnAction(e -> {
            rspn=false;
            stage.close();
        });
        Label question = new Label("Are you sure?");

        VBox layout = new VBox();
        layout.getChildren().addAll(question , no , yes);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();

        return rspn;
    }
}
