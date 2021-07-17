package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.*;
import java.lang.runtime.ObjectMethods;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GameCenter implements Initializable {


    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button gristmill , drapery,bakery,sewing,milkboxing,icecream,incubator;
    @FXML
    private Button upgristmill , updrapery,upbakery,upsewing,upmilkboxing,upicecream,upincubator;
    @FXML
    private ImageView imgv_bakery1 ,imgv_drapery1,imgv_gristmill1,imgv_icecream_incubator,imgv_milkboxing1,imgv_sewing1;
    @FXML
    private ImageView imgv_truck , imgv_storage;


    Image img_chicken = new Image(new File("chicken1.png").toURI().toString());
    Image img_turkey = new Image(new File("turkey1.png").toURI().toString());
    Image img_buffalo = new Image(new File("buffalo1.png").toURI().toString());
    Image img_cat = new Image(new File("cat1.png").toURI().toString());
    Image img_dog = new Image(new File("dog1.png").toURI().toString());

    Image img_bakery1 = new Image(new File("bakery1.png").toURI().toString());
    Image img_bakery2 = new Image(new File("bakery2.png").toURI().toString());
    Image img_drapery1 = new Image(new File("drapery1.png").toURI().toString());
    Image img_drapery2 = new Image(new File("drapery2.png").toURI().toString());
    Image img_gristmill1 = new Image(new File("gristmill1.png").toURI().toString());
    Image img_gristmill2 = new Image(new File("gristmill2.png").toURI().toString());
    Image img_icecream1 = new Image(new File("icecream1.png").toURI().toString());
    Image img_icecream2= new Image(new File("icecream2.png").toURI().toString());
    Image img_incubator1 = new Image(new File("incubator1.png").toURI().toString());
    Image img_incubator2 = new Image(new File("incubator2.png").toURI().toString());
    Image img_milkboxing1 = new Image(new File("milkboxing1.png").toURI().toString());
    Image img_milkboxing2 = new Image(new File("milkboxing2.png").toURI().toString());
    Image img_sewing1 = new Image(new File("sewing1.png").toURI().toString());
    Image img_sewing2 = new Image(new File("sewing2.png").toURI().toString());



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
        // extra part


        // extra part

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

    public int appoint_x(double x){
        if (x>=204 && x<245){
            return 1;
        }
        else if (x>=245 && x<286){
            return 2;
        }
        else if (x>=286 && x<327){
            return 3;
        }
        else if (x>=327 && x<368){
            return 4;
        }
        else if (x>=368 && x<409){
            return 5;
        }
        else if (x>=409 && x<=450){
            return 6;
        }
        return -1;
    }
    public int appoint_y(double y){
        if (y>=180 && y<210){
            return 1;
        }
        else if (y>=210 && y<240){
            return 2;
        }
        else if (y>=240 && y<270){
            return 3;
        }
        else if (y>=270 && y<300){
            return 4;
        }
        else if (y>=300 && y<330){
            return 5;
        }
        else if (y>=330 && y<=360){
            return 6;
        }
        return -1;
    }
    public int appoint_pos_x(int x){
        if (x==1){
            return 225;
        }
        else if (x==2){
            return 266;
        }
        else if (x==3){
            return 307;
        }
        else if (x==4){
            return 348;
        }
        else if (x==5){
            return 389;
        }
        else if (x==6){
            return 430;
        }
        return -1;
    }
    public int appoint_pos_y(int y){
        if (y==1){
            return 195;
        }
        else if (y==2){
            return 225;
        }
        else if (y==3){
            return 255;
        }
        else if (y==4){
            return 285;
        }
        else if (y==5){
            return 315;
        }
        else if (y==6){
            return 345;
        }
        return -1;
    }


    public void plantPickCage(MouseEvent e) throws IOException{
        double pos_x = e.getX();
        double pos_y = e.getY();

        System.out.println(pos_y);
        System.out.println(pos_x);

        boolean done = true;
        int x = appoint_x(pos_x);
        int y = appoint_y(pos_y);
        if (( x != -1 ) && ( y != -1 ) ){
            for (int i = 0; i < unpickedProductions.size(); i++) {
                UnpickedProductions production=unpickedProductions.get(i);
                if (production.getPlace_x() == x && production.getPlace_y() == y) {
                    done = false;
                    for (Map.Entry task : Tasks.entrySet()){
                        if (production.getType().equalsIgnoreCase(String.valueOf(task.getKey())))
                            task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
                    }
                    space = setSpaceGood(unpickedProductions.get(i).getType());
                    if (storage.storageList.containsKey(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()) {
                        storage.storageList.put(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT), Integer.parseInt(String.valueOf(storage.storageList.get(unpickedProductions.get(i).getType())) )+ 1);
                        storage.setSpace(storage.getSpace()+space);
                        unpickedProductions.remove(i);
                        System.out.println("Picked up!");
                        //  log
                        Writerlog = new FileWriter(Whatsup, true);
                        WBufferlog = new BufferedWriter(Writerlog);
                        PWriterlog = new PrintWriter(WBufferlog);
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Picking Up item");
                        PWriterlog.close();
                        //  log
                    }else if (!storage.storageList.containsKey(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()){
                        storage.storageList.put(unpickedProductions.get(i).getType().toLowerCase(Locale.ROOT), 1);
                        storage.setSpace(storage.getSpace()+space);
                        System.out.println("Picked up!");
                        //  log
                        Writerlog = new FileWriter(Whatsup, true);
                        WBufferlog = new BufferedWriter(Writerlog);
                        PWriterlog = new PrintWriter(WBufferlog);
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Picking Up item");
                        PWriterlog.close();
                        //  log
                        unpickedProductions.remove(i);
                    }
                    else{
                        System.out.println("Watch out! Your storage is full");
                        //  log
                        Writerlog = new FileWriter(Whatsup, true);
                        WBufferlog = new BufferedWriter(Writerlog);
                        PWriterlog = new PrintWriter(WBufferlog);
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Storage is full!");
                        PWriterlog.close();
                        //  log
                    }
                    break;
                }
            }
            if (done){
                for (int i = 0; i < wildAnimals.size(); i++) {
                    int[] place_checkup = wildAnimals.get(i).getPlace();
                    if (x == place_checkup[0] && y == place_checkup[1]) {
                        if (wildAnimals.get(i).getMaxCageStep() > wildAnimals.get(i).getCageStep()) {
                            done = false;
                            wildAnimals.get(i).setRemainedTimeInCage(1);
                            wildAnimals.get(i).setCageStep(wildAnimals.get(i).getCageStep() + 1);
                            System.out.println("increased one step for put in cage!");
                            //  log
                            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Use cage command");
                            //  log
                        }
                        if (wildAnimals.get(i).getMaxCageStep() == wildAnimals.get(i).getCageStep()) {
                            if (!wildAnimals.get(i).isCompletedCage()){
                                wildAnimals.get(i).setCompletedCage(true);
                            }
                            if (storage.getSpace() + 15 <= storage.getMaxSpace()) {
                                storage.storageList.put(wildAnimals.get(i).getName().toLowerCase(Locale.ROOT), 1);
                                storage.setSpace(storage.getSpace() + 15);
                                wildAnimals.remove(i);
                            } else {
                                System.out.println("There is not enough space in storage!");
                                //  log
                                PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Low space in storage");
                                //  log
                            }
                        }
                        break;
                    }
                }
                if (done){
                    if (well.getCurrentCapacity() >= 100) {
                        farm.setPlant(x, y);
                        done=false;
                        well.setCurrentCapacity(well.getCurrentCapacity() - 100);
                        System.out.println("Planted!!!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Planted");
                        //  log
                    } else {
                        System.out.println("You don't have enough water to plant");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Planted");
                        //  log
                    }
                }
            }
        }
    }


    //  upgrade
    public void upgradeGristmill() throws IOException{
        for (Factory factory : factories) {
            if (factory.getfName().equalsIgnoreCase("gristmill") && factory.isExist()) {
                if ( coins >= (factory.getBuildPrice()/2) ) {
                    coins -= (factory.getBuildPrice()/2);
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    imgv_gristmill1.setImage(img_gristmill2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
                if (coins >= (factory.getBuildPrice()/2)) {
                    coins -= (factory.getBuildPrice()/2);
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    imgv_drapery1.setImage(img_drapery2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
                if (coins >= (factory.getBuildPrice()/2) ) {
                    coins -= (factory.getBuildPrice()/2) ;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    imgv_milkboxing1.setImage(img_milkboxing2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
                if ( coins >= (factory.getBuildPrice()/2) ) {
                    coins -= (factory.getBuildPrice()/2) ;
                    player_upgrade.play();
                    player_upgrade.setAutoPlay(true);
                    player_upgrade.seek(player_upgrade.getStartTime());
                    imgv_sewing1.setImage(img_sewing2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
                    imgv_bakery1.setImage(img_bakery2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
                    imgv_icecream_incubator.setImage(img_icecream2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getfName().equalsIgnoreCase("incubator") ){
                factories.get(i).setLevel(1);
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
                    imgv_icecream_incubator.setImage(img_incubator2);
                    //System.out.println("Factory is upgraded. Enjoy :) ");
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
        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getfName().equalsIgnoreCase("iceCream") ){
                factories.get(i).setLevel(1);
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
            imgv_gristmill1.setImage(img_gristmill1);
            imgv_gristmill1.setOnMouseClicked( e -> workGristmill());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            gristmill.setDisable(true);
            upgristmill.setDisable(false);
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
    }
    public void buildDrapery(){
        Factory factory = new Factory("drapery");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            imgv_drapery1.setImage(img_drapery1);
            imgv_drapery1.setOnMouseClicked( e -> workdrapery());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            drapery.setDisable(true);
            updrapery.setDisable(false);
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
    }
    public void buildMilkBoxing(){
        Factory factory = new Factory("milkBoxing");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            imgv_milkboxing1.setImage(img_milkboxing1);
            imgv_milkboxing1.setOnMouseClicked( e -> workMilkBoxing());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            milkboxing.setDisable(true);
            upmilkboxing.setDisable(false);
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
    }
    public void buildSewing(){
        Factory factory = new Factory("sewing");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            imgv_sewing1.setImage(img_sewing1);
            imgv_sewing1.setOnMouseClicked( e -> worksewing());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            sewing.setDisable(true);
            upsewing.setDisable(false);
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
    }
    public void buildBakery(){
        Factory factory = new Factory("bakery");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            imgv_bakery1.setImage(img_bakery1);
            imgv_bakery1.setOnMouseClicked( e -> workBakery() );
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            bakery.setDisable(true);
            upbakery.setDisable(false);
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
    }
    public void buildIceCream(){
        Factory factory = new Factory("iceCream");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            imgv_icecream_incubator.setImage(img_icecream1);
            imgv_icecream_incubator.setOnMouseClicked( e -> workIceCream());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            icecream.setDisable(true);
            incubator.setDisable(false);
            upincubator.setDisable(true);
            upicecream.setDisable(false);
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
    }
    public void buildIncubator(){
        Factory factory = new Factory("incubator");
        int x = 0;
        if ( coins >= factory.getBuildPrice()) {
            player_sell_buy.play();
            player_sell_buy.setAutoPlay(true);
            player_sell_buy.seek(player_sell_buy.getStartTime());
            imgv_icecream_incubator.setImage(img_incubator1);
            imgv_icecream_incubator.setOnMouseClicked( e -> workIncubator());
            x = 1;
            factories.add(factory);
            coins -= factory.getBuildPrice();
            //System.out.println("New Factory added!");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "New Factory added");
            //  log
            incubator.setDisable(true);
            icecream.setDisable(false);
            upicecream.setDisable(true);
            upincubator.setDisable(false);
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
    }
    //  build

    //  work
    public void workGristmill(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("gristmill")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        System.out.println("There is not enough input in storage!");
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }
                }
                break;
            }
        }
    }
    public void workBakery(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("bakery")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        System.out.println("There is not enough input in storage!");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }
                }
                break;
            }
        }
    }
    public void workdrapery(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("drapery")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        System.out.println("There is not enough input in storage!");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }


                }
                break;
            }
        }
    }
    public void workMilkBoxing(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("milkBoxing")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        System.out.println("There is not enough input in storage!");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }
                }
                break;
            }
        }
    }
    public void worksewing(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("sewing")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        System.out.println("There is not enough input in storage!");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }
                }
                break;
            }
        }
    }
    public void workIceCream(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("iceCream")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        System.out.println("There is not enough input in storage!");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }
                }
                break;
            }
        }
    }
    public void workIncubator(){
        int x = 0 ;
        for (Factory factory1 : factories) {
            if (factory1.getfName().equalsIgnoreCase("incubator")) {
                x = 1;
                if (factory1.isWorking()) {
                    x = 2;
                    System.out.println("The factory is working on material.Try later.");
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Work command failed");
                    //  log
                }
                if (x == 1) {

                    space=setSpaceGood(factory1.getInputProduction());

                    if (storage.storageList.containsKey(factory1.getInputProduction())) {
                        if (storage.storageList.get(factory1.getInputProduction()) != 1){
                            storage.storageList.put(factory1.getInputProduction(), storage.storageList.get(factory1.getInputProduction()) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(factory1.getInputProduction());
                            storage.setSpace(storage.getSpace()-space);
                        }
                        factory1.setWorking(true);
                        System.out.println("The factory start working!");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Working started");
                        //  log
                    }
                    else{
                        System.out.println("There is not enough input in storage!");
                        player_fool.play();
                        player_fool.seek(player_fool.getStartTime());
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Not enough input for factory");
                        //  log
                    }
                }
                break;
            }
        }
    }
    //  work

    //  buy
    public void buyChicken() throws IOException{
        DomesticAnimal dome = new DomesticAnimal("chicken");
        if (coins >= dome.getPrice()) {
            ImageView imgv_ch = new ImageView();
            rootPane.getChildren().add(imgv_ch);
            player_sell_buy.play();
            player_sell_buy.seek(player_sell_buy.getStartTime());
            chickenNo++;
            dome.setName(dome.getName() + chickenNo);
            chickens.add(dome);
            imgv_ch.setImage(img_chicken);
            imgv_ch.setLayoutX(appoint_pos_x(dome.getPlace()[0])-36.0);
            imgv_ch.setLayoutY(appoint_pos_y(dome.getPlace()[1])-36.0);
            imgv_ch.setFitWidth(43.0);
            imgv_ch.setFitHeight(43.0);
            dome.setImgv_dome(imgv_ch);
            //System.out.println("You have your new chicken");
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
            ImageView imgv_turkey = new ImageView();
            rootPane.getChildren().add(imgv_turkey);
            player_sell_buy.play();
            player_sell_buy.seek(player_sell_buy.getStartTime());
            turkeyNo++;
            dome.setName(dome.getName() + turkeyNo);
            turkeies.add(dome);
            imgv_turkey.setImage(img_turkey);
            imgv_turkey.setLayoutX(appoint_pos_x(dome.getPlace()[0])-45.0);
            imgv_turkey.setLayoutY(appoint_pos_y(dome.getPlace()[1])-36.0);
            imgv_turkey.setFitWidth(50.0);
            imgv_turkey.setFitHeight(45.0);
            dome.setImgv_dome(imgv_turkey);
            //System.out.println("You have your new turkey");
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
            ImageView imgv_buffalo = new ImageView();
            rootPane.getChildren().add(imgv_buffalo);
            player_sell_buy.play();
            player_sell_buy.seek(player_sell_buy.getStartTime());
            buffaloNo++;
            dome.setName(dome.getName() + buffaloNo);
            buffalos.add(dome);
            imgv_buffalo.setImage(img_buffalo);
            imgv_buffalo.setLayoutX(appoint_pos_x(dome.getPlace()[0])-91.0);
            imgv_buffalo.setLayoutY(appoint_pos_y(dome.getPlace()[1])-65.0);
            imgv_buffalo.setFitWidth(91.0);
            imgv_buffalo.setFitHeight(65.0);
            dome.setImgv_dome(imgv_buffalo);
            //System.out.println("You have your new buffalo");
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
            ImageView imgv_cat = new ImageView();
            rootPane.getChildren().add(imgv_cat);
            player_sell_buy.play();
            player_sell_buy.seek(player_sell_buy.getStartTime());
            cat.setNumber(cats.size() + 1);
            cats.add(cat);
            imgv_cat.setImage(img_cat);
            imgv_cat.setLayoutX(appoint_pos_x(cat.getPlace()[0])-45.0);
            imgv_cat.setLayoutY(appoint_pos_y(cat.getPlace()[1])-41.0);
            imgv_cat.setFitWidth(50.0);
            imgv_cat.setFitHeight(58.0);
            cat.setImgv_cat(imgv_cat);
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

            //System.out.println("You have your new cat");
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
            //System.out.println("You don't have enough money to buy a cat!");
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
            ImageView imgv_dog = new ImageView();
            rootPane.getChildren().add(imgv_dog);
            player_sell_buy.play();
            player_sell_buy.seek(player_sell_buy.getStartTime());
            dog.setNumber(gunDogs.size() + 1);
            gunDogs.add(dog);
            imgv_dog.setImage(img_dog);
            imgv_dog.setLayoutX(appoint_pos_x(dog.getPlace()[0])-51.0);
            imgv_dog.setLayoutY(appoint_pos_y(dog.getPlace()[1])-46.0);
            imgv_dog.setFitWidth(57.0);
            imgv_dog.setFitHeight(53.0);
            dog.setImgv_dog(imgv_dog);
            coins -= dog.getPrice();
            for (Map.Entry task : Tasks.entrySet()){
                if (String.valueOf(task.getKey()).equalsIgnoreCase("Hound"))
                    task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
            }
            //System.out.println("You have your new Hound");
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
            //System.out.println("You don't have enough money to buy a Hound!");
            player_fool.play();
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

    // well
    public void well() throws IOException{
        if (well.getCurrentCapacity() == 0) {
            if (!well.isFilling()) {
                if (coins >= 15) {
                    coins -= 15;
                    player_well.play();
                    player_well.setAutoPlay(true);
                    player_well.seek(player_well.getStartTime());
                    well.setFilling(true);
                    //System.out.println("Start to filling tanker ...");
                    //  log
                    Writerlog = new FileWriter(Whatsup, true);
                    WBufferlog = new BufferedWriter(Writerlog);
                    PWriterlog = new PrintWriter(WBufferlog);
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Filling the tanker");
                    PWriterlog.close();
                    //  log
                }
                else {
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                }
            }
            else{
                //System.out.println("Tanker is full !");
                player_fool.play();
                player_fool.seek(player_fool.getStartTime());
                //  log
                PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Well failed (is full)");
                //  log
            }
        } else {
            player_fool.play();
            player_fool.seek(player_fool.getStartTime());
            //System.out.println("You still have some water in well.");
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Tanker wasn't empty.Well failed");
            //  log
        }
    }
    // well

    //  truck
    public boolean truckGo() throws  IOException{
        if (IsDrivenCar) {
            System.out.println("The truck is not available!");
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "To be unavailable in truck");
            //  log
            return true;
        }
        else if (car.loadList.isEmpty()){
            System.out.println("The truck is empty!");
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Empty truck for going");
            //  log
            return true;
        }
        else {
            IsDrivenCar = true;
            System.out.println("Truck went ...");
            //  log
            PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Truck went");
            //  log
            return false;
        }
    }
    public void truckLoad(String str) throws IOException{
        String[] strings = str.split(" ");
        if (strings[1].equalsIgnoreCase("load")) {
            str = strings[2].toLowerCase(Locale.ROOT);
            price = setPriceGood(str);
            space = setSpaceGood(str);
            if (price == -1 || space == -1) {
                System.out.println("Load name is wrong.");
                //  log
                PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Wrong load name");
                //  log
            }
            else if (!IsDrivenCar){
                if (storage.storageList.containsKey(str.toLowerCase(Locale.ROOT))) {
                    if (car.getSpace() + space <= car.getMaxSpace()) {
                        if (!car.loadList.containsKey(str)) {
                            car.loadList.put(str.toLowerCase(Locale.ROOT), 1);
                            car.setSellCoins(car.getSellCoins() + price);
                            car.setSpace(car.getSpace() + space);
                        } else {
                            car.loadList.put(str.toLowerCase(Locale.ROOT), car.loadList.get(str) + 1);
                            car.setSellCoins(car.getSellCoins() + price);
                            car.setSpace(car.getSpace() + space);
                        }

                        space=setSpaceGood(str);


                        if (storage.storageList.get(str)-1 != 0) {
                            storage.storageList.put(str, storage.storageList.get(str) - 1);
                            storage.setSpace(storage.getSpace()-space);
                        }else {
                            storage.storageList.remove(str);
                            storage.setSpace(storage.getSpace()-space);
                        }


                        System.out.println("putting load in truck was successful.");
                        //  log
                        PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "put Load in truck");
                        //  log
                    } else {
                        System.out.println("There is not enough space in truck!");
                        //  log
                        PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Low space in truck");
                        //  log
                    }
                } else {
                    System.out.println("you don't have this good in storage!");
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "not be in storage for truck");
                    //  log
                }
            }
            else{
                System.out.println("Truck is on street now!");
                //  log
                PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Busy truck");
                //  log
            }
        }
    }
    public void truckUnload(String str) throws IOException{
        String[] strings = str.split(" ");
        str = strings[2].toLowerCase(Locale.ROOT);
        price = setPriceGood(str);
        space = setSpaceGood(str);
//        if (price == -1 || space == -1) {
//            System.out.println("Load name is wrong.");
//            //  log
//            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Wrong load name");
//            //  log
//        }
        if (!IsDrivenCar){
            if (car.loadList.containsKey(str.toLowerCase(Locale.ROOT))) {
                car.setSellCoins(car.getSellCoins() - price);
                car.setSpace(car.getSpace() - space);

                if (car.loadList.get(str)-1 != 0) {
                    car.loadList.put(str, storage.storageList.get(str) - 1);
                }else {
                    car.loadList.remove(str);
                }

                if (storage.storageList.containsKey(str) && storage.getSpace()+space<=storage.getMaxSpace()) {
                    storage.storageList.put(str, Integer.parseInt(String.valueOf(storage.storageList.get(str)) )+ 1);
                    storage.setSpace(storage.getSpace()+space);
                    System.out.println("Load was taken out successfully.");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Taking out load");
                    //  log
                }else if (!storage.storageList.containsKey(str) && storage.getSpace()+space<=storage.getMaxSpace()){
                    storage.storageList.put(str, 1);
                    storage.setSpace(storage.getSpace()+space);
                    System.out.println("Load was taken out successfully.");
                    //  log
                    PWriterlog.println("[Info]" + dtfNow.format(LocalDateTime.now()) + "Taking out load");
                    //  log
                }
                else{
                    System.out.println("Watch out! Your storage is full");
                    //  log
                    PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Storage is full!");
                    //  log
                }

            } else {
                System.out.println("There is not any load with this name!");
                //  log
                PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Wrong load name");
                //  log
            }
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Take out load from truck");
            //  log
        }
        else {
            System.out.println("Truck is on street now!");
            //  log
            PWriterlog.println("[Error]" + dtfNow.format(LocalDateTime.now()) + "Busy truck");
            //  log
        }
    }
    public void showStorage() throws IOException{
        ChoiceBox<String> storageBox = new ChoiceBox<>();
        ImageView imgv_panel = new ImageView();
        Button ok_button = new Button("OK");
        Image img_panel = new Image(new File("Storage_panel1.png").toURI().toString());
        imgv_panel.setLayoutX(175);
        imgv_panel.setLayoutY(50);
        imgv_panel.setFitHeight(450);
        imgv_panel.setImage(img_panel);
        for (Map.Entry hash : storage.storageList.entrySet()){
            if (Integer.parseInt(hash.getValue().toString())!=0){
                String str = "";
                str += (hash.getKey().toString() + " " + hash.getValue().toString());
                storageBox.getItems().add(str);
            }
        }
        storageBox.setLayoutX(300);
        storageBox.setLayoutY(150);
        storageBox.show();
        ok_button.setLayoutX(315);
        ok_button.setLayoutY(425);
        imgv_storage.setOnMouseClicked(null);
        imgv_truck.setOnMouseClicked(null);

        rootPane.getChildren().addAll(imgv_panel,storageBox,ok_button);
        ok_button.setOnAction( e -> {
            imgv_truck.setOnMouseClicked( e1 -> {
                try {
                    truckAssistant();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            imgv_storage.setOnMouseClicked( e1 -> {
                try {
                    showStorage();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            rootPane.getChildren().removeAll(storageBox,ok_button,imgv_panel);
        });
    }
    public void truckAssistant() throws IOException{
        ChoiceBox<String> storageBox = new ChoiceBox<>();
        ChoiceBox<String> truckBox = new ChoiceBox<>();
        ImageView imgv_panel = new ImageView();
        Button go_button = new Button("Truck go");
        Button load_button = new Button("Truck load");
        Button unload_button = new Button("Truck unload");
        Button exit_button = new Button("Exit");
        Image img_panel = new Image(new File("truck_panel1.png").toURI().toString());
        imgv_panel.setImage(img_panel);
        for (Map.Entry hash : storage.storageList.entrySet()){
            if (Integer.parseInt(hash.getValue().toString())!=0){
                String str = "";
                str += (hash.getKey().toString() + " " + hash.getValue().toString());
                storageBox.getItems().add(str);
            }
        }
        for (Map.Entry hash : car.loadList.entrySet()){
            if (Integer.parseInt(hash.getValue().toString())!=0){
                String str = "";
                str += (hash.getKey().toString() + " " + hash.getValue().toString());
                truckBox.getItems().add(str);
            }
        }
        go_button.setOnAction( e -> {
            try {
                if (truckGo()){
                    player_fool.play();
                    player_fool.seek(player_fool.getStartTime());
                }
                else {
                    imgv_storage.setOnMouseClicked( e1 -> {
                        try {
                            showStorage();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                    imgv_truck.setOnMouseClicked( e1 -> {
                        try {
                            truckAssistant();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                    rootPane.getChildren().removeAll(imgv_panel,storageBox,truckBox,go_button,load_button,unload_button,exit_button);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        load_button.setOnAction( e -> {
            try {
                if (storageBox.getValue().toString().equals(null)){
                    System.out.println("Nothing selected");
                }
                else {
                    String str = "truck load ";
                    String[] strings = storageBox.getValue().toString().split(" ");
                    str += strings[0];
                    truckLoad(str);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        unload_button.setOnAction( e -> {
            try {
                if (storageBox.getValue().toString().equals(null)){
                    System.out.println("Nothing selected");
                }
                else {
                    String str = "truck unload ";
                    String[] strings = storageBox.getValue().toString().split(" ");
                    str += strings[0];
                    truckUnload(str);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } );
        exit_button.setOnAction( e -> {
            imgv_storage.setOnMouseClicked( e1 -> {
                try {
                    showStorage();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            imgv_truck.setOnMouseClicked( e1 -> {
                try {
                    truckAssistant();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            rootPane.getChildren().removeAll(imgv_panel,storageBox,truckBox,go_button,load_button,unload_button,exit_button);
        });

        imgv_panel.setLayoutY(25);
        imgv_panel.setLayoutX(130);
        imgv_panel.setFitHeight(375);
        imgv_panel.setFitWidth(400);
        load_button.setLayoutX(200);
        load_button.setLayoutY(125);
        unload_button.setLayoutX(200);
        unload_button.setLayoutY(200);
        go_button.setLayoutX(225);
        go_button.setLayoutY(300);
        exit_button.setLayoutX(400);
        exit_button.setLayoutY(300);
        storageBox.setLayoutX(400);
        storageBox.setLayoutY(125);
        truckBox.setLayoutX(400);
        truckBox.setLayoutY(200);
        imgv_storage.setOnMouseClicked(null);
        imgv_truck.setOnMouseClicked(null);

        rootPane.getChildren().addAll(imgv_panel,storageBox,truckBox,go_button,load_button,unload_button,exit_button);
    }
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
