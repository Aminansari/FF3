package sample;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Account {
    private String Username;
    private String Password;
    private int SelectedLevel;
    Scanner input =new Scanner(System.in);

    public boolean USERNAME (String gottenUsername) throws IOException {
        File Whatsup = new File("..\\log.txt");
        DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
        LocalDateTime now;
        FileWriter Writer=new FileWriter(Whatsup,true);
        BufferedWriter WBuffer = new BufferedWriter(Writer);
        PrintWriter PWriter = new PrintWriter(WBuffer);

        boolean isFine = true;
        boolean UserNameFeatureCheckup = true;
        while (UserNameFeatureCheckup) {
            while (isFine) {
                String username_org = gottenUsername;
                char[] username = username_org.toCharArray();
                int numberofusername = username_org.length();
                if (numberofusername < 6 || numberofusername > 30) {
                    AlertBox.displayAlert("Inappropriate username! Username must be 6-30 letters.");
                    //log
                    now= LocalDateTime.now() ;
                    PWriter.println("[Error]"+dtfNow.format(now)+"Inappropriate username");
                    PWriter.close();
                    //log
                    isFine=false;
                    break;
                }
                if (!((username[0] >= 65 && username[0] <= 90) || (username[0] >= 97 && username[0] <= 122))) {
                    AlertBox.displayAlert("Inappropriate username! First letter must be from alphabet.");
                    //log
                    now= LocalDateTime.now() ;
                    PWriter.println("[Error]"+dtfNow.format(now)+"Inappropriate username");
                    PWriter.close();
                    //log
                    isFine=false;
                    break;
                }
                for (int l = 0; l < numberofusername; l++) {
                    if (!((username[l] >= 65 && username[l] <= 90) || (username[l] >= 97 && username[l] <= 122) || username[l] == 95 || (username[l] >= 48 && username[l] <= 57))) {
                        AlertBox.displayAlert("Inappropriate username! You only can use alphabet or number or underline.");
                        //log
                        now= LocalDateTime.now() ;
                        PWriter.println("[Error]"+dtfNow.format(now)+"Inappropriate username");
                        PWriter.close();
                        //log
                        isFine=false;
                        break;
                    }
                }
                break;
            }
            UserNameFeatureCheckup = false;
        }
        return isFine;
    }

    public boolean PASSWORD (String gottenPassword) throws IOException {
        File Whatsup = new File("..\\log.txt");
        DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
        LocalDateTime now;
        FileWriter Writer=new FileWriter(Whatsup,true);
        BufferedWriter WBuffer = new BufferedWriter(Writer);
        PrintWriter PWriter = new PrintWriter(WBuffer);

        boolean isFine = true;
        boolean PasswordFeatureCheckup = true;
        while (PasswordFeatureCheckup){
            while (isFine) {
                String password_org = gottenPassword;
                char[] password = password_org.toCharArray();
                int numberofpassword = password_org.length();
                if (numberofpassword < 8 || numberofpassword > 20) {
                    AlertBox.displayAlert("Inappropriate password! Username must be 8-20 letters.");
                    now= LocalDateTime.now() ;
                    PWriter.println("[Error]"+dtfNow.format(now)+"Inappropriate password");
                    PWriter.close();
                    System.out.println("try again");
                    isFine=false;
                    break;
                }
                int number = 0, capletter = 0, smallletter = 0, speacial = 0;
                for (int l = 0; l < numberofpassword; l++) {
                    if ((password[l] >= 65 && password[l] <= 90)) {
                        capletter++;
                    }
                    if (password[l] >= 97 && password[l] <= 122) {
                        smallletter++;
                    }
                    if (password[l] >= 48 && password[l] <= 57) {
                        number++;
                    }
                    if ((password[l] == 94) || (password[l] == 61) || (password[l] == 45) || (password[l] == 43) || (password[l] == 41) || (password[l] == 40) || (password[l] == 42) || (password[l] == 38) || (password[l] == 37) || (password[l] == 36) || (password[l] == 35) || (password[l] == 33) || (password[l] == 64)) {
                        speacial++;
                    }
                    if (password[l] == 32) {
                        AlertBox.displayAlert("Inappropriate password! All separations are illegal.");
                        //log
                        now= LocalDateTime.now() ;
                        PWriter.println("[Error]"+dtfNow.format(now)+"Inappropriate password");
                        PWriter.close();
                        //log
                        System.out.println("try again");
                        isFine=false;
                        break;
                    }
                }
                if (capletter == 0 || number == 0 || smallletter == 0 || speacial == 0) {
                    AlertBox.displayAlert("Inappropriate password! At least your password must have one symbol from !@#$%&*()-+=^ and one number and one letter for each little and capital.");
                    //log
                    now= LocalDateTime.now() ;
                    PWriter.println("[Error]"+dtfNow.format(now)+"Inappropriate password");
                    PWriter.close();
                    //log
                    System.out.println("try again");
                    isFine=false;
                    break;
                }
                break;
            }
            PasswordFeatureCheckup=false;
        }
        return isFine;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getSelectedLevel() {
        return SelectedLevel;
    }

    public void setSelectedLevel(int selectedLevel) {
        SelectedLevel = selectedLevel;
    }
}
