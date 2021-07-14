package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GameCenter implements Initializable {


    @FXML
    private Button gristmill , drapery,bakery,sewing,milkboxing,icecream,incubator;
    @FXML
    private Button upgristmill , updrapery,upbakery,upsewing,upmilkboxing,upicecream,upincubator;



    Media media_sell_buy = new Media(getClass().getResource("action_sell_buy.mp3").toString());
    MediaPlayer player_sell_buy = new MediaPlayer(media_sell_buy);
    Media media_upgrade = new Media(getClass().getResource("action_upgrade.mp3").toString());
    MediaPlayer player_upgrade = new MediaPlayer(media_upgrade);
    Media media_fool_action = new Media(getClass().getResource("fool_action.mp3").toString());
    MediaPlayer player_fool = new MediaPlayer(media_fool_action);
    Media media_well = new Media(getClass().getResource("action_well_water.mp3").toString());
    MediaPlayer player_well = new MediaPlayer(media_well);



    // for reading name from login or signup
    File file = new File("name.txt");
    FileReader nameReader;

    {
        try {
            nameReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BufferedReader bnameReader = new BufferedReader(nameReader);
    String username;
    //  for reading name from login or signup
    BufferedWriter WBuffer;
    FileWriter Writer;
    PrintWriter PWriter;
    FileReader Reader;
    BufferedReader RBuffer;
    //      #files#
    File Whatsup = new File("..\\log.txt");
    DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
    File AccountFile = new File("..\\Farm Frenzy 3(Users)/" + username + ".txt");
    //      #files#
    FileWriter Writerlog;
    BufferedWriter WBufferlog;
    PrintWriter PWriterlog;
    //CHECK_Amin**********************************
    ArrayList<WildAnimal> wildAnimals = new ArrayList<>();
    Storage storage = new Storage();
    Car car = new Car();
    int price = 0;
    int space = 0;
    //int passedTimeCar = 0;
    boolean IsDrivenCar = false;
    int passedTime = 0;
    Farm farm = new Farm();
    int chickenNo = 0;
    int turkeyNo = 0;
    int buffaloNo = 0;
    boolean isPickedCoin=false;
    //***************************************
    //CHECK_Matin**********************************
    ArrayList<Cat> cats = new ArrayList<>();
    ArrayList<GunDog> gunDogs = new ArrayList<>();
    ArrayList<DomesticAnimal> turkeies = new ArrayList<>();
    ArrayList<DomesticAnimal> buffalos = new ArrayList<>();
    ArrayList<DomesticAnimal> chickens = new ArrayList<>();
    ArrayList<UnpickedProductions> unpickedProductions = new ArrayList<>();
    ArrayList<Factory> factories = new ArrayList<>();
    HashMap<String, Integer> Tasks = new HashMap<>();
    Well well = new Well(500);
    int coins;
    int giftedCoin;
    int giftCoin;
    int thisLevel;
    int maxLevel;
    boolean isGifted = false;
    boolean isMaxlevel = false;
    String pass;
    //***************************************

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // music part
        // music part

        //File Whatsup = new File("..\\log.txt");
        //DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
        //File AccountFile = new File("..\\Farm Frenzy 3(Users)/" + Farmer.getUsername() + ".txt");

        //matinBuff****************************
        //FileWriter Writerlog;
        //BufferedWriter WBufferlog;
        //PrintWriter PWriterlog;
        try {
            upbakery.setDisable(true);
            upicecream.setDisable(true);
            upmilkboxing.setDisable(true);
            upsewing.setDisable(true);
            updrapery.setDisable(true);
            upgristmill.setDisable(true);
            upincubator.setDisable(true);
            username = bnameReader.readLine();
            String[] strings = bnameReader.readLine().split(" ");
            thisLevel = Integer.parseInt(strings[1]);
            bnameReader.close();
            nameReader.close();
            file.delete();               //  the -name.txt- will be deleted here...
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            //separate matuse and matlog
            FileWriter WriterUser;
            BufferedWriter WBufferUser;
            PrintWriter PWriterUser;
            FileReader ReaderUser = new FileReader(AccountFile);
            BufferedReader RBufferUser = new BufferedReader(ReaderUser);
            //matinBuff****************************

        } catch (IOException e) {
            e.printStackTrace();
        }



        //reading mission***************************************
        File mission = new File("..\\Farm Frenzy 3(Missions)/Mission.txt");
        File thisMission = new File("..\\Farm Frenzy 3(Missions)/Mission" + thisLevel + ".txt");
        try {
            Reader = new FileReader(mission);
            RBuffer = new BufferedReader(Reader);
            int numberOfAllLevels = Integer.parseInt(RBuffer.readLine());
            RBuffer.close();
            Reader = new FileReader(thisMission);
            RBuffer = new BufferedReader(Reader);
            coins = Integer.parseInt(RBuffer.readLine());
            ArrayList<String> wildAnimalsInMission = new ArrayList<>();
            String[] tasks = RBuffer.readLine().split(" ");
            for (int i = 0; i < tasks.length; i += 2) {
                Tasks.put(tasks[i], Integer.valueOf(tasks[i + 1]));
            }
            String[] allWildAnimals = RBuffer.readLine().split(" ");
            for (int i = 0; i < allWildAnimals.length; i += 2) {
                wildAnimalsInMission.add(allWildAnimals[i]+" "+allWildAnimals[i+1]);
            }
            int goldenTime = Integer.parseInt(RBuffer.readLine());
            giftCoin = Integer.parseInt(RBuffer.readLine());
            RBuffer.close();
            //******************************************************
            //reading User***************************************
            Reader = new FileReader(AccountFile);
            RBuffer = new BufferedReader(Reader);
            pass = RBuffer.readLine();
            maxLevel = Integer.parseInt(RBuffer.readLine());
            if (maxLevel==thisLevel)
                isMaxlevel=true;
            giftedCoin = Integer.parseInt(RBuffer.readLine());
            RBuffer.close();
            //***************************************************
            coins+=giftedCoin;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry task : Tasks.entrySet()){
            if("coin".equalsIgnoreCase(String.valueOf(task.getKey())))
                if (Integer.parseInt(String.valueOf(task.getValue()))<=coins)
                    isPickedCoin=true;
        }

    }

    //  upgrade
    public void upgradeGristmill() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("gristmill") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    upgristmill.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }
            }
        }
    }
    public void upgradeDrapery() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("drapery") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    updrapery.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }
            }
        }
    }
    public void upgradeMilkBoxing() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("milkBoxing") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    upmilkboxing.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }

            }
        }
    }
    public void upgradeSewing() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("sewing") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    upsewing.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }
            }
        }
    }
    public void upgradeBakery() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("bakery") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    upbakery.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }
            }
        }
    }
    public void upgradeIcecream() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("iceCream") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    upicecream.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }
            }
        }
    }
    public void upgradeIncubator() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("incubator") && factory.isExist()) {
                if (coins >= factory.getBuildPrice()/2) {
                    coins -= factory.getBuildPrice()/2;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    System.out.println("Factory is upgraded. Enjoy :) ");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "The " + factory.getfName() + " Factory upgraded.");
                    //  log
                    factory.upgrade();
                    upincubator.setDisable(true);
                    break;
                }
                else {
                    player_fool.play();
                    player_fool.setAutoPlay(true);
                    player_fool.seek(player_fool.getStartTime());
                }
            }
        }
    }
    //  upgrade

    //  build
    public void buildGristmill(){
        Factory factory = new Factory("gristmill");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            //AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        gristmill.setDisable(true);
        upgristmill.setDisable(false);
    }
    public void buildDrapery(){
        Factory factory = new Factory("drapery");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        drapery.setDisable(true);
        updrapery.setDisable(false);
    }
    public void buildMilkBoxing(){
        Factory factory = new Factory("milkBoxing");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        milkboxing.setDisable(true);
        upmilkboxing.setDisable(false);
    }
    public void buildSewing(){
        Factory factory = new Factory("sewing");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        sewing.setDisable(true);
        upsewing.setDisable(false);
    }
    public void buildBakery(){
        Factory factory = new Factory("bakery");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        bakery.setDisable(true);
        upbakery.setDisable(false);
    }
    public void buildIceCream(){
        Factory factory = new Factory("iceCream");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        icecream.setDisable(true);
        upicecream.setDisable(false);
    }
    public void buildIncubator(){
        Factory factory = new Factory("incubator");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
        }
        if (x==0){
            AlertBox.displayAlert("You don't have enough money");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to start factory");
            //  log
        }
        incubator.setDisable(true);
        upincubator.setDisable(false);
    }
    //  build

    //  buy
    public void buyChicken() throws IOException{
        DomesticAnimal dome = new DomesticAnimal("chicken");
        if (coins >= dome.getPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            chickenNo++;
            dome.setName(dome.getName() + chickenNo);
            chickens.add(dome);
            System.out.println("You have your new chicken");
            coins -= dome.getPrice();
            for (Map.Entry task : Tasks.entrySet()) {
                if (dome.getName().startsWith(String.valueOf(task.getKey()).toLowerCase(Locale.ROOT)))
                    task.setValue(Integer.parseInt(String.valueOf(task.getValue())) - 1);
            }
            for (int i = 0; i < wildAnimals.size(); i++) {
                int[] wildPLACE = wildAnimals.get(i).getPlace();
                int[] domePLACE = dome.getPlace();
                if (wildPLACE[0] == domePLACE[0] && wildPLACE[1] == domePLACE[1]) {
                    //System.out.println("Chicken fell on wild animal! :(((");
                    chickens.remove(chickens.size() - 1);
                    break;
                }
            }
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Domestic animal");
            PWriterlog.close();
            //  log
        }
        else {
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to buy animal");
            PWriterlog.close();
            //  log
        }
    }
    public void buyTurkey()throws IOException{
        DomesticAnimal dome = new DomesticAnimal("turkey");
        if (coins >= dome.getPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            turkeyNo++;
            dome.setName(dome.getName() + turkeyNo);
            turkeies.add(dome);
            System.out.println("You have your new turkey");
            coins -= dome.getPrice();
            for (Map.Entry task : Tasks.entrySet()) {
                if (dome.getName().startsWith(String.valueOf(task.getKey()).toLowerCase(Locale.ROOT)))
                    task.setValue(Integer.parseInt(String.valueOf(task.getValue())) - 1);
            }
            for (int i = 0; i < wildAnimals.size(); i++) {
                int[] wildPLACE = wildAnimals.get(i).getPlace();
                int[] domePLACE = dome.getPlace();
                if (wildPLACE[0] == domePLACE[0] && wildPLACE[1] == domePLACE[1]) {
                    //System.out.println("Turkey fell on wild animal! :(((");
                    turkeies.remove(turkeies.size() - 1);

                    break;
                }
            }
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Domestic animal");
            PWriterlog.close();
            //  log
        }
        else {
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to buy animal");
            PWriterlog.close();
            //  log
        }
    }
    public void buyBuffalo() throws IOException{
        DomesticAnimal dome = new DomesticAnimal("buffalo");
        if (coins >= dome.getPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            buffaloNo++;
            dome.setName(dome.getName() + buffaloNo);
            buffalos.add(dome);
            System.out.println("You have your new buffalo");
            coins -= dome.getPrice();
            for (Map.Entry task : Tasks.entrySet()) {
                if (dome.getName().startsWith(String.valueOf(task.getKey()).toLowerCase(Locale.ROOT)))
                    task.setValue(Integer.parseInt(String.valueOf(task.getValue())) - 1);
            }

            for (int i = 0; i < wildAnimals.size(); i++) {
                int[] wildPLACE = wildAnimals.get(i).getPlace();
                int[] domePLACE = dome.getPlace();
                if (wildPLACE[0] == domePLACE[0] && wildPLACE[1] == domePLACE[1]) {
                    //System.out.println("Buffalo fell on wild animal! :(((");
                    buffalos.remove(buffalos.size() - 1);

                    break;
                }
            }
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Domestic animal");
            PWriterlog.close();
            //  log
        }
        else {
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to buy animal");
            PWriterlog.close();
            //  log
        }
    }
    public void buyCat() throws IOException{
        Cat cat = new Cat();
        if (coins >= cat.getPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            cat.setNumber(cats.size() + 1);
            cats.add(cat);
            coins -= cat.getPrice();
            for (Map.Entry task : Tasks.entrySet()){
                if (String.valueOf(task.getKey()).equalsIgnoreCase("Cat"))
                    task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
            }

            int[] catPLACE=cat.getPlace();
            for (int i = 0; i < unpickedProductions.size(); i++) {
                if (unpickedProductions.get(i).getPlace_x() == catPLACE[0] && unpickedProductions.get(i).getPlace_y() == catPLACE[1]) {

                    for (Map.Entry task : Tasks.entrySet()){
                        if (unpickedProductions.get(i).getType().equalsIgnoreCase(String.valueOf(task.getKey())))
                            task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
                    }
                    space = setSpaceGood(unpickedProductions.get(i).getType());
                    if (storage.storageList.containsKey(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()) {
                        storage.storageList.put(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT), Integer.parseInt(String.valueOf(storage.storageList.get(unpickedProductions.get(i).getType())) )+ 1);
                        storage.setSpace(storage.getSpace()+space);
                        unpickedProductions.remove(i);
                    }else if (!storage.storageList.containsKey(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()){
                        storage.storageList.put(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT), 1);
                        storage.setSpace(storage.getSpace()+space);
                        unpickedProductions.remove(i);
                    }
                    else{
                        System.out.println("Watch out! Your storage is full");
                    }

                }
            }

            System.out.println("You have your new cat");
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New cat");
            PWriterlog.close();
            //  log

            for (int i = 0; i < wildAnimals.size(); i++) {
                int[] wildPLACE=wildAnimals.get(i).getPlace();
                if (wildPLACE[0]==catPLACE[0]&&wildPLACE[1]==catPLACE[1])
                {
                    System.out.println("Cat fell on wild animal! :(((");
                    cats.remove(cats.size()-1);
                    break;
                }
            }
        } else {
            System.out.println("You don't have enough money to buy a cat!");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to buy animal");
            PWriterlog.close();
            //  log
        }
    }
    public void buyDog() throws IOException{
        GunDog dog = new GunDog();
        if (coins >= dog.getPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            dog.setNumber(gunDogs.size() + 1);
            gunDogs.add(dog);
            coins -= dog.getPrice();
            for (Map.Entry task : Tasks.entrySet()){
                if (String.valueOf(task.getKey()).equalsIgnoreCase("Hound"))
                    task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
            }
            System.out.println("You have your new Hound");
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Hound");
            PWriterlog.close();
            //  log
            for (int i = 0; i < wildAnimals.size(); i++) {
                int[] wildPLACE=wildAnimals.get(i).getPlace();
                int[] dogPLACE=dog.getPlace();
                if (wildPLACE[0]==dogPLACE[0]&&wildPLACE[1]==dogPLACE[1])
                {
                    System.out.println("Hound fell on wild animal! :)))");
                    gunDogs.remove(gunDogs.size()-1);
                    wildAnimals.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("You don't have enough money to buy a Hound!");
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            //  log
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough money to buy animal");
            PWriterlog.close();
            //  log
        }
    }
    //  buy

    // well & plant
    public void well() throws IOException{
        if (well.getCurrentCapacity() == 0) {
            if (!well.isFilling()) {
                player_well.play();
                player_well.setAutoPlay(true);
                player_well.seek(player_well.getStartTime());
                well.setFilling(true);
                System.out.println("Start to filling tanker ...");
                //  log
                Writerlog = new FileWriter(Whatsup, true);
                WBufferlog = new BufferedWriter(Writerlog);
                PWriterlog = new PrintWriter(WBufferlog);
                PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Filling the tanker");
                PWriterlog.close();
                //  log
            }
            else{
                System.out.println("Tanker is full !");
                //  log
                PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Well failed (is full)");
                //  log
            }
        } else {
            player_fool.play();
            player_fool.setAutoPlay(true);
            player_fool.seek(player_fool.getStartTime());
            System.out.println("You still have some water in well.");
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Tanker wasn't empty.Well failed");
            //  log
        }
    }
    // welll & plant

    //  truck
    public void truckGo() throws  IOException{}
    public void truckLoad() throws IOException{}
    public void truckUnload() throws IOException{}
    public void showStorage() throws IOException{}
    public void truckAssistant() throws IOException{}
    //  truck



    //  other function
    public int setSpaceGood(String Name) {
        if (Name.equalsIgnoreCase("egg")) {
            return 1;
        } else if (Name.equalsIgnoreCase("feather")) {

            return 1;
        } else if (Name.equalsIgnoreCase("milk")) {

            return 1;
        } else if (Name.equalsIgnoreCase("flour")) {

            return 2;
        } else if (Name.equalsIgnoreCase("cloth")) {

            return 2;
        } else if (Name.equalsIgnoreCase("packetmilk")) {

            return 2;
        } else if (Name.equalsIgnoreCase("bread")) {

            return 4;
        } else if (Name.equalsIgnoreCase("shirt")) {

            return 4;
        } else if (Name.equalsIgnoreCase("icecream")) {

            return 4;
        } else if (Name.toUpperCase().startsWith("TIGER")) {

            return 15;
        } else if (Name.toUpperCase().startsWith("BEAR")) {

            return 15;
        } else if (Name.toUpperCase().startsWith("LION")) {

            return 15;
        }

        return -1;
    }
    public int setPriceGood(String Name) {
        if (Name.equalsIgnoreCase("egg")) {
            return 15;

        } else if (Name.equalsIgnoreCase("feather")) {
            return 20;

        } else if (Name.equalsIgnoreCase("milk")) {
            return 25;

        } else if (Name.equalsIgnoreCase("flour")) {
            return 40;

        } else if (Name.equalsIgnoreCase("cloth")) {
            return 50;

        } else if (Name.equalsIgnoreCase("packetmilk")) {
            return 60;

        } else if (Name.equalsIgnoreCase("bread")) {
            return 80;

        } else if (Name.equalsIgnoreCase("shirt")) {
            return 100;

        } else if (Name.equalsIgnoreCase("icecream")) {
            return 120;

        } else if (Name.toUpperCase().startsWith("TIGER")) {
            return 500;

        } else if (Name.toUpperCase().startsWith("BEAR")) {
            return 400;

        } else if (Name.toUpperCase().startsWith("LION")) {
            return 300;

        }

        return -1;
    }
    public boolean endTasks(HashMap<String,Integer> hashMap) {

        for (Map.Entry hash : hashMap.entrySet()){
            if (Integer.parseInt(hash.getValue().toString())!=0){
                return false;
            }
        }
        return true;
    }
    public int NagativeToZero(int number) {
        if (number <= 0)
            return 0;
        return number;
    }
    public int[] UPRL(int[] place_org) {
        //0-Up/1-Down/2-Right/3-Left
        int[] place=new int[2];
        place[0]=place_org[0];
        place[1]=place_org[1];
        Random random = new Random();
        boolean isAcceptable = false;
        while (!isAcceptable) {
            int status = random.nextInt(4);
            if (status == 0) {
                if (place[1] + 1 <= 6) {
                    isAcceptable = true;
                    place[1]++;
                    return place;
                }
            } else if (status == 1) {
                if (place[1] - 1 > 0) {
                    isAcceptable = true;
                    place[1]--;
                    return place;
                }
            } else if (status == 2) {
                if (place[0] + 1 <= 6) {
                    isAcceptable = true;
                    place[0]++;
                    return place;
                }
            } else if (status == 3) {
                if (place[0] - 1 > 0) {
                    isAcceptable = true;
                    place[0]--;
                    return place;
                }
            }
        }
        int[] junk=place;
        return junk;
    }
    public int[] NearestGrassPlace(int[][] Grasses, DomesticAnimal domesticAnimal) {
        int[] nearestPlace = new int[2];
        int[] domesticPlace = domesticAnimal.getPlace();
        nearestPlace=UPRL(domesticPlace);
        double nearestLength = 999999999;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (Grasses[i][j] != 0) {
                    if (nearestLength >= Math.sqrt(Math.pow(i + 1 - domesticPlace[0], 2) + Math.pow(j + 1 - domesticPlace[1], 2))) {
                        nearestLength = Math.sqrt(Math.pow(i + 1 - domesticPlace[0], 2) + Math.pow(j + 1 - domesticPlace[1], 2));
                        nearestPlace[0] = i + 1;
                        nearestPlace[1] = j + 1;
                    }
                }
            }
        }
        return nearestPlace;
    }
    public int[] NearestProductionPlace(ArrayList<UnpickedProductions> unpickeds, Cat cat) {
        int[] nearestPlace = new int[2];
        int[] catPlace = cat.getPlace();
        nearestPlace=UPRL(catPlace);
        double nearestLength = 999999999;
        for (int i = 0; i < unpickeds.size(); i++) {
            if (nearestLength >= Math.sqrt(Math.pow(unpickeds.get(i).getPlace_x() - catPlace[0], 2) + Math.pow(unpickeds.get(i).getPlace_y() - catPlace[1], 2))) {
                nearestLength = Math.sqrt(Math.pow(unpickeds.get(i).getPlace_x() - catPlace[0], 2) + Math.pow(unpickeds.get(i).getPlace_y() - catPlace[1], 2));
                nearestPlace[0] = unpickeds.get(i).getPlace_x();
                nearestPlace[1] = unpickeds.get(i).getPlace_y();
            }
        }
        return nearestPlace;
    }
    //  other function



}
