package sample;


import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button back;
    @FXML
    private Button confirm;
    @FXML
    private ChoiceBox<String> selectedLevel = new ChoiceBox<>();
    @FXML
    private TextField password = new TextField();
    @FXML
    private TextField username = new TextField();
    @FXML
    private Button back2;
    @FXML
    private Button confirm2;
    @FXML
    private TextField password2 = new TextField();
    @FXML
    private TextField username2 = new TextField();
    private boolean isSign = false;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        selectedLevel.getItems().addAll("Level 1","Level 2","Level 3","Level 4","Level 5");

    }


    public void startLevel() throws IOException{
        File file = new File("name.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String user = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        BufferedWriter WBuffer;
        FileWriter Writer;
        PrintWriter PWriter;
        FileReader Reader;
        BufferedReader RBuffer;
        File AccountFile = new File("..\\Farm Frenzy 3(Users)/" + user + ".txt");
        DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
        File Whatsup = new File("..\\log.txt");

        Writer=new FileWriter(Whatsup,true);
        WBuffer=new BufferedWriter(Writer);
        PWriter=new PrintWriter(WBuffer);
        PWriter.println("[[[---"+user+"---]]]");
        PWriter.close();

        String selectedlevels = selectedLevel.getValue();
        fileWriter.write(selectedlevels+"\n");
        fileWriter.close();
        if (selectedlevels.equals(null)){
            AlertBox.displayAlert("You should choose a level first.");
        }
        else {
            String[] SelectedLevel = selectedlevels.split(" ");
            Reader = new FileReader(AccountFile);
            RBuffer = new BufferedReader(Reader);
            String line = RBuffer.readLine();
            String MaxLevel = RBuffer.readLine();
            RBuffer.close();
                if (Integer.parseInt(MaxLevel) >= Integer.parseInt(SelectedLevel[1]) && Integer.parseInt(SelectedLevel[1]) >= 1) {

                    File transferManagerToCommands = new File("..\\logEnter.txt");
                    transferManagerToCommands.createNewFile();
                    Writer = new FileWriter(transferManagerToCommands, true);
                    WBuffer = new BufferedWriter(Writer);
                    PWriter = new PrintWriter(WBuffer);

                    PWriter.println(user);
                    PWriter.println(SelectedLevel[1]);
                    PWriter.close();

                    Writer = new FileWriter(Whatsup, true);
                    WBuffer = new BufferedWriter(Writer);
                    PWriter = new PrintWriter(WBuffer);
                    PWriter.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Entered the game");
                    PWriter.close();
                    Main main = new Main();
                    main.changingScene("gameCenter.fxml");
                }
                else {
                    AlertBox.displayAlert("This level is locked for you! Select another level.");
                }
        }


    }

    public void confirmLogin(ActionEvent event) throws IOException{
        if (username2==null||password2==null){
            AlertBox.displayAlert("Nothing entered!");
        }
        else {
            if (checkAccount()){
                isSign=false;
                File file = new File("name.txt");
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write(username2.getText()+"\n");
                fileWriter.close();
                Main menu = new Main();
                menu.changingScene("Loggedin.fxml");
            }
        }
    }
    public void confirmUsePass(ActionEvent event) throws IOException {
        if (username==null||password==null){
            AlertBox.displayAlert("Nothing entered!");
        }
        else {
            Account account = new Account();
            System.out.println(username.getText());
            System.out.println(password.getText());
            if (account.USERNAME(username.getText())) {
                File RepeatCheckUp = new File("..\\Farm Frenzy 3(Users)/" + username.getText() + ".txt");
                if (!RepeatCheckUp.exists()) {
                    if (account.PASSWORD(password.getText())) {
                        createAccount();
                        isSign=true;
                        File file = new File("name.txt");
                        FileWriter fileWriter = new FileWriter(file,true);
                        fileWriter.write(username.getText()+"\n");
                        fileWriter.close();
                        Main main = new Main();
                        main.changingScene("Loggedin.fxml");
                    }
                }
                else {
                    AlertBox.displayAlert("There is another account with this username! Please enter another username.");
                }
            }
        }
    }

    public void back2Pressed(ActionEvent e)throws IOException{
        Main main = new Main();
        main.changingScene("Loggedin.fxml");
    }
    public void backPressed(ActionEvent e) throws IOException {
        Main main = new Main();
        main.changingScene("StartPage.fxml");
    }

    public void createAccount() throws IOException{
        BufferedWriter WBuffer;
        FileWriter Writer;
        PrintWriter PWriter;
        File AccountFile = new File("..\\Farm Frenzy 3(Users)/" + username.getText() + ".txt");
        AccountFile.createNewFile();

        Writer = new FileWriter(AccountFile,true);
        WBuffer = new BufferedWriter(Writer);
        PWriter = new PrintWriter(WBuffer);

        PWriter.println(password.getText());
        PWriter.println("1");
        PWriter.println("0");
        PWriter.close();
        File Whatsup = new File("..\\log.txt");
        Writer=new FileWriter(Whatsup,true);
        WBuffer = new BufferedWriter(Writer);
        PWriter = new PrintWriter(WBuffer);
        DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");

        PWriter.println("[Info]"+dtfNow.format(LocalDateTime.now())+"Signed up successfully");
        PWriter.close();
    }
    public boolean checkAccount() throws IOException{
        DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
        BufferedWriter WBuffer;
        FileWriter Writer;
        PrintWriter PWriter;
        File Whatsup = new File("..\\log.txt");
        File AccountFileCheckUp = new File("..\\Farm Frenzy 3(Users)/" + username2.getText() + ".txt");
        if(!AccountFileCheckUp.exists()) {
            Writer = new FileWriter(Whatsup, true);
            WBuffer = new BufferedWriter(Writer);
            PWriter = new PrintWriter(WBuffer);
            PWriter.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Wrong username");
            PWriter.close();
            AlertBox.displayAlert("There is no account with this username!");
            return false;
        }
        else {
            String PasswordCheckUp = password2.getText();
            FileReader AccountFileCheckUpReader = new FileReader(AccountFileCheckUp);
            BufferedReader AccountFileCheckUpBuffer = new BufferedReader(AccountFileCheckUpReader);
            String line;
            line = AccountFileCheckUpBuffer.readLine();
            if (PasswordCheckUp.equals(line)) {
                //log
                Writer=new FileWriter(Whatsup,true);
                WBuffer = new BufferedWriter(Writer);
                PWriter = new PrintWriter(WBuffer);
                PWriter.println("[Info]"+dtfNow.format(LocalDateTime.now())+"Logged in successfully");
                PWriter.close();
                //log
                return true;

            } else {
                Writer=new FileWriter(Whatsup,true);
                WBuffer = new BufferedWriter(Writer);
                PWriter = new PrintWriter(WBuffer);
                PWriter.println("[Error]"+dtfNow.format(LocalDateTime.now())+"Wrong password");
                PWriter.close();
                AlertBox.displayAlert("This is not the correct password!");
                return false;
            }
        }
    }
}
