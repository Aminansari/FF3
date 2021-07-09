package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class startPage {

    @FXML
    private Button exit;
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private Button logout;
    @FXML
    private Button start;
    @FXML
    private Button settings;



    public void exitPressed(ActionEvent e) throws IOException {
        Main main = new Main();
        main.exitPressed();
    }
    public void loginPressed(ActionEvent e) throws IOException{
        Main main = new Main();
        main.changingScene("login.fxml");
    }
    public void signupPressed(ActionEvent e) throws IOException{
        Main main = new Main();
        main.changingScene("sample.fxml");
    }
    public void logoutPressed(ActionEvent e) throws IOException{
        Main main = new Main();
        main.changingScene("startPage.fxml");
    }
    public void startPressed(ActionEvent e) throws IOException{
        Main main = new Main();
        main.changingScene("Level.fxml");
    }
}
