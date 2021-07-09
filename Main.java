package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setResizable(false);
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        primaryStage.setTitle("M&M Farm Frenzy 3");

        primaryStage.setOnCloseRequest(e ->{
            e.consume();
            try {
                closingProgram(primaryStage);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        primaryStage.setScene(new Scene(root, 571, 424));
        primaryStage.show();
    }
    public void changingScene(String new_scene) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(new_scene));
        stage.getScene().setRoot(root);
        if (new_scene.equals("gameCenter.fxml")){
            stage.setHeight(530.0);
            stage.setWidth(670.0);
        }
    }
    public void exitPressed() throws IOException{
        closingProgram(stage);
    }
    public void closingProgram(Stage stage1) throws IOException{
        boolean response = ConfirmBox.display();
        if (response){
            stage1.close();
            BufferedWriter WBuffer;
            FileWriter Writer;
            PrintWriter PWriter;
            File Whatsup = new File("..\\log.txt");
            Writer=new FileWriter(Whatsup,true);
            WBuffer = new BufferedWriter(Writer);
            PWriter = new PrintWriter(WBuffer);
            DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
            PWriter.println("[Info]"+dtfNow.format(LocalDateTime.now())+"Exit the game");
            PWriter.close();
            File file = new File("name.txt");
            file.delete();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
