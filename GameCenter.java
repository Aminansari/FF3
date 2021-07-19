package sample;

import javafx.application.Platform;
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
import javafx.scene.text.Text;

import java.io.*;
//import java.lang.runtime.ObjectMethods;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Turn extends Thread {
    private AnchorPane rootpane;
    private Farm farm ;
    private int passedTime;
    private ArrayList<DomesticAnimal> turkeies;
    private ArrayList<DomesticAnimal> buffalos;
    private ArrayList<DomesticAnimal> chickens;
    private ArrayList<UnpickedProductions> unpickedProductions;
    private ArrayList<Factory> factories;
    private int chickenNo;
    private HashMap<String, Integer> Tasks;
    private ArrayList<WildAnimal> wildAnimals;
    private ArrayList<String> wildAnimalsInMission;
    private ArrayList<Cat> cats;
    private  ImageView frontMouse;
    private ImageView carInRoad;

    private Text coin;
    private ImageView imgv_well;
    private ImageView imgv_bakery1 ,imgv_drapery1,imgv_gristmill1,imgv_icecream_incubator,imgv_milkboxing1,imgv_sewing1;


    Image img_chicken = new Image(new File("chicken1.png").toURI().toString());
    Image img_turkey = new Image(new File("turkey1.png").toURI().toString());
    Image img_buffalo = new Image(new File("buffalo1.png").toURI().toString());
    Image img_cat = new Image(new File("cat1.png").toURI().toString());
    Image img_dog = new Image(new File("dog1.png").toURI().toString());
    Image img_toRcar= new Image(new File("Rcar.png").toURI().toString());
    Image img_toLcar= new Image(new File("Lcar.png").toURI().toString());

    private int[] passedTimeC = new int[1];
    private int[] chickenNoO = new int[1];
    private boolean[] IsPickedCoinO = new boolean[1];
    private int[] coinO = new int[1];
    private boolean[] IsDrivenO = new boolean[1];

    public int getGiftCoin() {
        return giftCoin;
    }

    public void setGiftCoin(int giftCoin) {
        this.giftCoin = giftCoin;
    }

    private int giftCoin;


    // for reading name from login or signup
    File file = new File("name.txt");
    FileReader nameReader;
    private int thisLevel;


    private boolean IsDrivenCar;
    private Car car;
    private int coins;
    private boolean isPickedCoin;
    private int space;
    private Storage storage;
    private ArrayList<GunDog> gunDogs;
    private Well well;
    private String[] tasks;
    private MediaPlayer wellSound;
    private boolean isMaxlevel;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;

    public boolean isMaxlevel() {
        return isMaxlevel;
    }

    public void setMaxlevel(boolean maxlevel) {
        isMaxlevel = maxlevel;
    }

    public boolean isGifted() {
        return isGifted;
    }

    private boolean isGifted;
    private int maxLevel;
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

    public void setAccountFile(File accountFile) {
        AccountFile = accountFile;
    }

    File AccountFile;
    //      #files#
    FileWriter Writerlog;

    {
        try {
            Writerlog = new FileWriter(Whatsup, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;
    BufferedWriter WBufferlog = new BufferedWriter(Writerlog);;
    PrintWriter PWriterlog = new PrintWriter(WBufferlog);;


    //separate matuse and matlog
    FileWriter WriterUser;
    BufferedWriter WBufferUser;
    PrintWriter PWriterUser;

    private MediaPlayer mediaPlayer;
    LocalDateTime now;

    public void run(){
        Platform.setImplicitExit(false);
        try {
            Media media = new Media(getClass().getResource("Russia.mp3").toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.4);
            mediaPlayer.play();
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            FileReader ReaderUser= new FileReader(AccountFile);
            BufferedReader RBufferUser = new BufferedReader(ReaderUser);

            imgv_well.setImage(new Image(new File("w1_1.png").toURI().toString()));
            imgv_well.toFront();
boolean booly =true;
            while (booly){
                if (endTasks(Tasks)) {

                    if (isMaxlevel && 5!=maxLevel) {
                        maxLevel++;
                    }


                    if (!isGifted) {
                        giftCoin = 0;
                    }
                    WriterUser = new FileWriter(AccountFile, false);
                    WBufferUser = new BufferedWriter(WriterUser);
                    PWriterUser = new PrintWriter(WBufferUser);

                    PWriterUser.println(pass);
                    PWriterUser.println(maxLevel);
                    PWriterUser.println(giftCoin);
                    PWriterUser.close();
                    //  log
                    Writerlog = new FileWriter(Whatsup, true);
                    WBufferlog = new BufferedWriter(Writerlog);
                    PWriterlog = new PrintWriter(WBufferlog);
                    now = LocalDateTime.now();
                    PWriterlog.println("[Info]" + dtfNow.format(now) + "Entered Menu");
                    PWriterlog.close();
                    //  log
                    File transferManagerToMenu = new File("..\\logEnter.txt");
                    transferManagerToMenu.createNewFile();

                    Writer = new FileWriter(transferManagerToMenu,true);
                    WBuffer = new BufferedWriter(Writer);
                    PWriter = new PrintWriter(WBuffer);

                    PWriter.println(username);
                    PWriter.close();

                    mediaPlayer.pause();
                    File file = new File("name.txt");
                    try {
                        FileWriter fileWriter = new FileWriter(file,true);
                        WBuffer=new BufferedWriter(fileWriter);
                        PWriter=new PrintWriter(WBuffer);
                        PWriter.println(username);
                        PWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    booly=false;
                    Main main = new Main();
                    try {
                        main.changingScene("Level.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Thread.sleep(1000);
                // #turn#
                //      #آلارم چمن#
                int x=0;
                for (int i = 0; i < 6; i++) {
                    for (int k = 0; k < 6; k++) {
                        if(farm.isPlant(i+1,k+1)) {
                            x=1;
                            break;
                        }
                    }
                    if (x==1)
                        break;
                }
                if (x==0)
                    System.out.println("Watch out! Your farm has no plant.");
                //      #آلارم چمن#

                //      #افزایش زمان#
                passedTime+=255;
                passedTimeC[0]+=255;
                //      #افزایش زمان#

                //      #کاهش جون اهلی#
                for (int i = 0; i < chickens.size(); i++) {
                    chickens.get(i).setSpanTime(chickens.get(i).getSpanTime() - 10);
                    if (chickens.get(i).getSpanTime() == 0) {
                        chickens.get(i).getImgv_dome().setImage(null);
                        chickens.remove(i);
                        i--;
                    }
                }
                for (int i = 0; i < turkeies.size(); i++) {
                    turkeies.get(i).setSpanTime(turkeies.get(i).getSpanTime() - 10);
                    if (turkeies.get(i).getSpanTime() == 0) {
                        turkeies.get(i).getImgv_dome().setImage(null);
                        turkeies.remove(i);
                        i--;
                    }
                }
                for (int i = 0; i < buffalos.size(); i++) {
                    buffalos.get(i).setSpanTime(buffalos.get(i).getSpanTime() - 10);
                    if (buffalos.get(i).getSpanTime() == 0) {
                        buffalos.get(i).getImgv_dome().setImage(null);
                        buffalos.remove(i);
                        i--;
                    }
                }
                //      #کاهش جون اهلی#
                //      #حذف کالای روی زمین#
                for (int i = 0; i < unpickedProductions.size(); i++) {
                    unpickedProductions.get(i).setChangableUnpickedTime(unpickedProductions.get(i).getChangableUnpickedTime()-1);
                    if (unpickedProductions.get(i).getChangableUnpickedTime()==0) {
                        unpickedProductions.get(i).getImgv_unpickedProduction().setImage(null);
                        unpickedProductions.remove(i);
                        i--;
                    }
                }
                //      #حذف کالای روی زمین#
                //       #محصول کارگاه#
                for (int i = 0; i < factories.size(); i++) {
                    if (factories.get(i).isWorking()) {
                        factories.get(i).setChangableProductionTime(factories.get(i).getChangableProductionTime() - 1);



                        if (factories.get(i).getChangableProductionTime() == 0) {
                            if(!factories.get(i).getfName().equals("incubator")) {
                                Random rand = new Random();
                                unpickedProductions.add(new UnpickedProductions(factories.get(i).getOutputProduction(), rand.nextInt(6) + 1, rand.nextInt(6) + 1));
                                Platform.runLater(new Runnable(){

                                    @Override
                                    public void run() {
                                        rootpane.getChildren().add(unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction());
                                        frontMouse.toFront();
                                    }
                                });

                                unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutX(appoint_pos_x(unpickedProductions.get(unpickedProductions.size()-1).getPlace_x())-36.0);
                                unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutY(appoint_pos_y(unpickedProductions.get(unpickedProductions.size()-1).getPlace_y())-36.0);
                                unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitWidth(43.0);
                                unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitHeight(43.0);
                            }
                            else{
                                // #جوجه کشی#
                                chickenNo++;
                                chickenNoO[0]++;
                                DomesticAnimal dome = new DomesticAnimal("chicken");
                                dome.setName(dome.getName() + chickenNoO[0]);
                                chickens.add(dome);
                                System.out.println("You have your new chicken from factory.");
                                ImageView imgv_ch = new ImageView();
                                rootpane.getChildren().add(imgv_ch);
                                frontMouse.toFront();
                                imgv_ch.setImage(img_chicken);
                                imgv_ch.setLayoutX(appoint_pos_x(dome.getPlace()[0])-36.0);
                                imgv_ch.setLayoutY(appoint_pos_y(dome.getPlace()[1])-36.0);
                                imgv_ch.setFitWidth(43.0);
                                imgv_ch.setFitHeight(43.0);
                                dome.setImgv_dome(imgv_ch);
                                for (Map.Entry task : Tasks.entrySet()){
                                    if (dome.getName().startsWith(String.valueOf(task.getKey()).toLowerCase(Locale.ROOT)))
                                        task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
                                }

                                for (int r = 0; r < wildAnimals.size(); r++) {
                                    int[] wildPLACE=wildAnimals.get(r).getPlace();
                                    int[] domePLACE=dome.getPlace();
                                    if (wildPLACE[0]==domePLACE[0]&&wildPLACE[1]==domePLACE[1])
                                    {
                                        System.out.println("Chicken fell on wild animal! :(((");
                                        Platform.runLater(new Runnable() {
                                            @Override
                                            public void run() {
                                                rootpane.getChildren().remove(chickens.get(chickens.size()-1).getImgv_dome());
                                            }
                                        });
                                        chickens.remove(chickens.size()-1);

                                        break;
                                    }
                                }

                                //  log
                                Writerlog = new FileWriter(Whatsup, true);
                                WBufferlog = new BufferedWriter(Writerlog);
                                PWriterlog = new PrintWriter(WBufferlog);
                                now = LocalDateTime.now();
                                PWriterlog.println("[Info]" + dtfNow.format(now) + "New Domestic animal from incubator");
                                PWriterlog.close();
                                //  log

                            }
                            factories.get(i).setChangableProductionTime(factories.get(i).getProductionTime());
                            factories.get(i).setWorking(false);
                        }
                    }
                }
                //       #محصول کارگاه#
                //         #ماشین فروش#
                if (IsDrivenO[0]) {
                    car.setChangableSellDuration(car.getChangableSellDuration() -1);
                    if (car.getChangableSellDuration() == 0) {
                        coins += car.getSellCoins();
                        coinO[0]+= car.getSellCoins();
                        coin.setText(String.valueOf(coins));
                        for (Map.Entry task : Tasks.entrySet()){
                            if("coin".equalsIgnoreCase(String.valueOf(task.getKey())))
                                if (Integer.parseInt(String.valueOf(task.getValue()))<=coinO[0])
                                    isPickedCoin=true;
                                IsPickedCoinO[0]=true;
                        }
                        car.setSpace(0);
                        car.setChangableSellDuration(car.getSellDuration());
                        car.setSellCoins(0);
                        IsDrivenCar = false;
                        IsDrivenO[0]=false;
                        carInRoad.setImage(null);
                    }
                }
                //         #ماشین فروش#
                //         #ورود حیوانات وحشی#
                for (int i = 0; i < wildAnimalsInMission.size(); i++) {
                    String[] wildtemparary=wildAnimalsInMission.get(i).split(" ");
                    if (Integer.parseInt(wildtemparary[1]) == passedTimeC[0]) {
                        wildAnimals.add(new WildAnimal(wildtemparary[0]));
                        Platform.runLater(new Runnable(){

                            @Override
                            public void run() {
                                rootpane.getChildren().add(wildAnimals.get(wildAnimals.size()-1).getImgv_wild());
                                frontMouse.toFront();
                            }
                        });
                        wildAnimals.get(wildAnimals.size()-1).getImgv_wild().setLayoutX(appoint_pos_x(wildAnimals.get(wildAnimals.size()-1).getPlace()[0])-36.0);
                        wildAnimals.get(wildAnimals.size()-1).getImgv_wild().setLayoutY(appoint_pos_y(wildAnimals.get(wildAnimals.size()-1).getPlace()[1])-36.0);
                        wildAnimals.get(wildAnimals.size()-1).getImgv_wild().setFitWidth(43.0);
                        wildAnimals.get(wildAnimals.size()-1).getImgv_wild().setFitHeight(43.0);


//                                for (int k = 0; k < chickens.size(); k++) {
//                                    int[] wildPLace = wildAnimals.get(wildAnimals.size()-1).getPlace();
//                                    int[] otherThingPlace = chickens.get(k).getPlace();
//                                    if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
//                                        chickens.remove(k);
//                                        k--;
//                                    }
//                                }
//                                for (int k = 0; k < turkeies.size(); k++) {
//                                    int[] wildPLace = wildAnimals.get(wildAnimals.size()-1).getPlace();
//                                    int[] otherThingPlace = turkeies.get(k).getPlace();
//                                    if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
//                                        turkeies.remove(k);
//                                        k--;
//                                    }
//                                }
//                                for (int k = 0; k < buffalos.size(); k++) {
//                                    int[] wildPLace = wildAnimals.get(wildAnimals.size()-1).getPlace();
//                                    int[] otherThingPlace = buffalos.get(k).getPlace();
//                                    if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
//                                        buffalos.remove(k);
//                                        k--;
//                                    }
//                                }
//                                for (int k = 0; k < cats.size(); k++) {
//                                    int[] wildPLace = wildAnimals.get(wildAnimals.size()-1).getPlace();
//                                    int[] otherThingPlace = cats.get(k).getPlace();
//                                    if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
//                                        cats.remove(k);
//                                        k--;
//                                    }
//                                }
//                                for (int k = 0; k < unpickedProductions.size(); k++) {
//                                    int[] wildPLace = wildAnimals.get(wildAnimals.size()-1).getPlace();
//                                    int[] otherThingPlace = unpickedProductions.get(k).getPlace();
//                                    if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
//                                        unpickedProductions.remove(k);
//                                        k--;
//                                    }
//                                }
//                                for (int k = 0; k < gunDogs.size(); k++) {
//                                    int[] wildPLace = wildAnimals.get(wildAnimals.size()-1).getPlace();
//                                    int[] otherThingPlace = gunDogs.get(k).getPlace();
//                                    if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
//                                        chickens.remove(k);
//                                        wildAnimals.remove(wildAnimals.size()-1);
//                                        break;
//                                    }
//                                }
                    }
                }
                //         #ورود حیوانات وحشی#
                //         #حرکت اهلی#
                for (int i = 0; i < chickens.size(); i++) {
                    if (chickens.get(i).getSpanTime() <= 50) {
                        int[] nearestGrass = NearestGrassPlace(farm.getPosition(), chickens.get(i));
                        int[] animalPlace = chickens.get(i).getPlace();
                        if (nearestGrass[0] > animalPlace[0]) {
                            animalPlace[0]++;
                            chickens.get(i).setPlace(animalPlace[0], animalPlace[1]);
                            chickens.get(i).getImgv_dome().setLayoutX(appoint_pos_x(chickens.get(i).getPlace()[0])-36.0);
                            chickens.get(i).getImgv_dome().setLayoutY(appoint_pos_y(chickens.get(i).getPlace()[1])-36.0);
                        } else if (nearestGrass[0] < animalPlace[0]) {
                            animalPlace[0]--;
                            chickens.get(i).setPlace(animalPlace[0], animalPlace[1]);
                            chickens.get(i).getImgv_dome().setLayoutX(appoint_pos_x(chickens.get(i).getPlace()[0])-36.0);
                            chickens.get(i).getImgv_dome().setLayoutY(appoint_pos_y(chickens.get(i).getPlace()[1])-36.0);
                        } else {
                            if (nearestGrass[1] > animalPlace[1]) {
                                animalPlace[1]++;
                                chickens.get(i).setPlace(animalPlace[0], animalPlace[1]);
                                chickens.get(i).getImgv_dome().setLayoutX(appoint_pos_x(chickens.get(i).getPlace()[0])-36.0);
                                chickens.get(i).getImgv_dome().setLayoutY(appoint_pos_y(chickens.get(i).getPlace()[1])-36.0);
                            } else if (nearestGrass[1] < animalPlace[1]) {
                                animalPlace[1]--;
                                chickens.get(i).setPlace(animalPlace[0], animalPlace[1]);
                                chickens.get(i).getImgv_dome().setLayoutX(appoint_pos_x(chickens.get(i).getPlace()[0])-36.0);
                                chickens.get(i).getImgv_dome().setLayoutY(appoint_pos_y(chickens.get(i).getPlace()[1])-36.0);
                            }
                        }
                    } else {
                        chickens.get(i).setPlace(UPRL(chickens.get(i).getPlace()));
                        chickens.get(i).getImgv_dome().setLayoutX(appoint_pos_x(chickens.get(i).getPlace()[0])-36.0);
                        chickens.get(i).getImgv_dome().setLayoutY(appoint_pos_y(chickens.get(i).getPlace()[1])-36.0);
                    }
                }
                for (int i = 0; i < turkeies.size(); i++) {
                    if (turkeies.get(i).getSpanTime() <= 50) {
                        int[] nearestGrass = NearestGrassPlace(farm.getPosition(), turkeies.get(i));
                        int[] animalPlace = turkeies.get(i).getPlace();
                        if (nearestGrass[0] > animalPlace[0]) {
                            animalPlace[0]++;
                            turkeies.get(i).setPlace(animalPlace[0], animalPlace[1]);
                            turkeies.get(i).getImgv_dome().setLayoutX(appoint_pos_x(turkeies.get(i).getPlace()[0])-36.0);
                            turkeies.get(i).getImgv_dome().setLayoutY(appoint_pos_y(turkeies.get(i).getPlace()[1])-36.0);
                        } else if (nearestGrass[0] < animalPlace[0]) {
                            animalPlace[0]--;
                            turkeies.get(i).setPlace(animalPlace[0], animalPlace[1]);
                            turkeies.get(i).getImgv_dome().setLayoutX(appoint_pos_x(turkeies.get(i).getPlace()[0])-36.0);
                            turkeies.get(i).getImgv_dome().setLayoutY(appoint_pos_y(turkeies.get(i).getPlace()[1])-36.0);
                        } else {
                            if (nearestGrass[1] > animalPlace[1]) {
                                animalPlace[1]++;
                                turkeies.get(i).setPlace(animalPlace[0], animalPlace[1]);
                                turkeies.get(i).getImgv_dome().setLayoutX(appoint_pos_x(turkeies.get(i).getPlace()[0])-36.0);
                                turkeies.get(i).getImgv_dome().setLayoutY(appoint_pos_y(turkeies.get(i).getPlace()[1])-36.0);
                            } else if (nearestGrass[1] < animalPlace[1]) {
                                animalPlace[1]--;
                                turkeies.get(i).setPlace(animalPlace[0], animalPlace[1]);
                                turkeies.get(i).getImgv_dome().setLayoutX(appoint_pos_x(turkeies.get(i).getPlace()[0])-36.0);
                                turkeies.get(i).getImgv_dome().setLayoutY(appoint_pos_y(turkeies.get(i).getPlace()[1])-36.0);
                            }
                        }
                    } else {
                        turkeies.get(i).setPlace(UPRL(turkeies.get(i).getPlace()));
                        turkeies.get(i).getImgv_dome().setLayoutX(appoint_pos_x(turkeies.get(i).getPlace()[0])-36.0);
                        turkeies.get(i).getImgv_dome().setLayoutY(appoint_pos_y(turkeies.get(i).getPlace()[1])-36.0);
                    }
                }
                for (int i = 0; i < buffalos.size(); i++) {
                    if (buffalos.get(i).getSpanTime() <= 50) {
                        int[] nearestGrass = NearestGrassPlace(farm.getPosition(), buffalos.get(i));
                        int[] animalPlace = buffalos.get(i).getPlace();
                        if (nearestGrass[0] > animalPlace[0]) {
                            animalPlace[0]++;
                            buffalos.get(i).setPlace(animalPlace[0], animalPlace[1]);
                            buffalos.get(i).getImgv_dome().setLayoutX(appoint_pos_x(buffalos.get(i).getPlace()[0])-36.0);
                            buffalos.get(i).getImgv_dome().setLayoutY(appoint_pos_y(buffalos.get(i).getPlace()[1])-36.0);
                        } else if (nearestGrass[0] < animalPlace[0]) {
                            animalPlace[0]--;
                            buffalos.get(i).setPlace(animalPlace[0], animalPlace[1]);
                            buffalos.get(i).getImgv_dome().setLayoutX(appoint_pos_x(buffalos.get(i).getPlace()[0])-36.0);
                            buffalos.get(i).getImgv_dome().setLayoutY(appoint_pos_y(buffalos.get(i).getPlace()[1])-36.0);
                        } else {
                            if (nearestGrass[1] > animalPlace[1]) {
                                animalPlace[1]++;
                                buffalos.get(i).setPlace(animalPlace[0], animalPlace[1]);
                                buffalos.get(i).getImgv_dome().setLayoutX(appoint_pos_x(buffalos.get(i).getPlace()[0])-36.0);
                                buffalos.get(i).getImgv_dome().setLayoutY(appoint_pos_y(buffalos.get(i).getPlace()[1])-36.0);
                            } else if (nearestGrass[1] < animalPlace[1]) {
                                animalPlace[1]--;
                                buffalos.get(i).setPlace(animalPlace[0], animalPlace[1]);
                                buffalos.get(i).getImgv_dome().setLayoutX(appoint_pos_x(buffalos.get(i).getPlace()[0])-36.0);
                                buffalos.get(i).getImgv_dome().setLayoutY(appoint_pos_y(buffalos.get(i).getPlace()[1])-36.0);
                            }
                        }
                    } else {
                        buffalos.get(i).setPlace(UPRL(buffalos.get(i).getPlace())) ;
                        buffalos.get(i).getImgv_dome().setLayoutX(appoint_pos_x(buffalos.get(i).getPlace()[0])-36.0);
                        buffalos.get(i).getImgv_dome().setLayoutY(appoint_pos_y(buffalos.get(i).getPlace()[1])-36.0);
                    }
                }
                //         #حرکت اهلی#
                //       #محصول اهلی#
                for (int i = 0; i < chickens.size(); i++) {
                    chickens.get(i).setChangableProduceTime(chickens.get(i).getChangableProduceTime() - 1);
                    if (chickens.get(i).getChangableProduceTime() == 0) {
                        int[] tempPlace = chickens.get(i).getPlace();
                        unpickedProductions.add(new UnpickedProductions(chickens.get(i).getProduction(), tempPlace[0], tempPlace[1]));

                        Platform.runLater(new Runnable(){

                            @Override
                            public void run() {
                                rootpane.getChildren().add(unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction());
                                frontMouse.toFront();
                            }
                        });

                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutX(appoint_pos_x(unpickedProductions.get(unpickedProductions.size()-1).getPlace_x())-36.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutY(appoint_pos_y(unpickedProductions.get(unpickedProductions.size()-1).getPlace_y())-36.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitWidth(43.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitHeight(43.0);
                        chickens.get(i).setChangableProduceTime(chickens.get(i).getProduceTime());
                    }
                }
                for (int i = 0; i < turkeies.size(); i++) {
                    turkeies.get(i).setChangableProduceTime(turkeies.get(i).getChangableProduceTime() - 1);
                    if (turkeies.get(i).getChangableProduceTime() == 0) {
                        int[] tempPlace = turkeies.get(i).getPlace();
                        unpickedProductions.add(new UnpickedProductions(turkeies.get(i).getProduction(), tempPlace[0], tempPlace[1]));
                        Platform.runLater(new Runnable(){

                            @Override
                            public void run() {
                                rootpane.getChildren().add(unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction());
                                frontMouse.toFront();
                            }
                        });

                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutX(appoint_pos_x(unpickedProductions.get(unpickedProductions.size()-1).getPlace_x())-36.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutY(appoint_pos_y(unpickedProductions.get(unpickedProductions.size()-1).getPlace_y())-36.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitWidth(43.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitHeight(43.0);
                        turkeies.get(i).setChangableProduceTime(turkeies.get(i).getProduceTime());
                    }
                }
                for (int i = 0; i < buffalos.size(); i++) {
                    buffalos.get(i).setChangableProduceTime(buffalos.get(i).getChangableProduceTime() - 1);
                    if (buffalos.get(i).getChangableProduceTime() == 0) {
                        int[] tempPlace = buffalos.get(i).getPlace();
                        unpickedProductions.add(new UnpickedProductions(buffalos.get(i).getProduction(), tempPlace[0], tempPlace[1]));
                        Platform.runLater(new Runnable(){

                            @Override
                            public void run() {
                                rootpane.getChildren().add(unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction());
                                frontMouse.toFront();
                            }
                        });

                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutX(appoint_pos_x(unpickedProductions.get(unpickedProductions.size()-1).getPlace_x())-36.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setLayoutY(appoint_pos_y(unpickedProductions.get(unpickedProductions.size()-1).getPlace_y())-36.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitWidth(43.0);
                        unpickedProductions.get(unpickedProductions.size()-1).getImgv_unpickedProduction().setFitHeight(43.0);
                        buffalos.get(i).setChangableProduceTime(buffalos.get(i).getProduceTime());
                    }
                }
                //       #محصول اهلی#
                //         #حرکت گربه#
                for (int i = 0; i < cats.size(); i++) {
                    if (!unpickedProductions.isEmpty()) {
                        int[] nearestProduction = NearestProductionPlace(unpickedProductions, cats.get(i));
                        int[] animalPlace = cats.get(i).getPlace();
                        if (nearestProduction[0] > animalPlace[0]) {
                            animalPlace[0]++;
                            cats.get(i).setPlace(animalPlace);
                            cats.get(i).getImgv_cat().setLayoutX(appoint_pos_x(cats.get(i).getPlace()[0])-36.0);
                            cats.get(i).getImgv_cat().setLayoutY(appoint_pos_y(cats.get(i).getPlace()[1])-36.0);
                        } else if (nearestProduction[0] < animalPlace[0]) {
                            animalPlace[0]--;
                            cats.get(i).setPlace(animalPlace);
                            cats.get(i).getImgv_cat().setLayoutX(appoint_pos_x(cats.get(i).getPlace()[0])-36.0);
                            cats.get(i).getImgv_cat().setLayoutY(appoint_pos_y(cats.get(i).getPlace()[1])-36.0);
                        } else {
                            if (nearestProduction[1] > animalPlace[1]) {
                                animalPlace[1]++;
                                cats.get(i).setPlace(animalPlace);
                                cats.get(i).getImgv_cat().setLayoutX(appoint_pos_x(cats.get(i).getPlace()[0])-36.0);
                                cats.get(i).getImgv_cat().setLayoutY(appoint_pos_y(cats.get(i).getPlace()[1])-36.0);
                            } else if (nearestProduction[1] < animalPlace[1]) {
                                animalPlace[1]--;
                                cats.get(i).setPlace(animalPlace);
                                cats.get(i).getImgv_cat().setLayoutX(appoint_pos_x(cats.get(i).getPlace()[0])-36.0);
                                cats.get(i).getImgv_cat().setLayoutY(appoint_pos_y(cats.get(i).getPlace()[1])-36.0);}
//                                     else {
//                                        for (int s = 0; s < unpickedProductions.size(); s++) {
//                                            if (unpickedProductions.get(s).getPlace_x() == animalPlace[0] && unpickedProductions.get(s).getPlace_y() == animalPlace[1]) {
//                                                space = setSpaceGood(unpickedProductions.get(s).getType());
//
//                                                if (storage.storageList.containsKey(unpickedProductions.get(s).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()) {
//                                                    storage.storageList.put(unpickedProductions.get(s).getType().toLowerCase(Locale.ROOT), Integer.parseInt(String.valueOf(storage.storageList.get(unpickedProductions.get(s).getType())) )+ 1);
//                                                    storage.setSpace(storage.getSpace()+space);
//                                                    unpickedProductions.remove(s);
//                                                }else if (!storage.storageList.containsKey(unpickedProductions.get(s).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()){
//                                                    storage.storageList.put(unpickedProductions.get(s).getType().toLowerCase(Locale.ROOT), 1);
//                                                    storage.setSpace(storage.getSpace()+space);
//                                                    unpickedProductions.remove(s);
//                                                }
//                                                else{
//                                                    System.out.println("Watch out! Your storage is full");
//                                                }
//
//                                            }
//                                        }
//                                    }
                        }
                        for (int Q = 0; Q < unpickedProductions.size(); Q++) {
                            if (unpickedProductions.get(Q).getPlace_x() == animalPlace[0] && unpickedProductions.get(Q).getPlace_y() == animalPlace[1]) {

                                space = setSpaceGood(unpickedProductions.get(Q).getType());

                                if (storage.storageList.containsKey(unpickedProductions.get(Q).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()) {
                                    storage.storageList.put(unpickedProductions.get(Q).getType().toLowerCase(Locale.ROOT), Integer.parseInt(String.valueOf(storage.storageList.get(unpickedProductions.get(Q).getType())) )+ 1);
                                    storage.setSpace(storage.getSpace()+space);
                                    for (Map.Entry task : Tasks.entrySet()){
                                        if (unpickedProductions.get(Q).getType().equalsIgnoreCase(String.valueOf(task.getKey())))
                                            task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
                                    }
                                    unpickedProductions.get(Q).getImgv_unpickedProduction().setImage(null);
                                    unpickedProductions.remove(Q);
                                }else if (!storage.storageList.containsKey(unpickedProductions.get(Q).getType().toLowerCase(Locale.ROOT)) && storage.getSpace()+space<=storage.getMaxSpace()){
                                    storage.storageList.put(unpickedProductions.get(Q).getType().toLowerCase(Locale.ROOT), 1);
                                    storage.setSpace(storage.getSpace()+space);
                                    for (Map.Entry task : Tasks.entrySet()){
                                        if (unpickedProductions.get(Q).getType().equalsIgnoreCase(String.valueOf(task.getKey())))
                                            task.setValue(Integer.parseInt(String.valueOf(task.getValue()))-1);
                                    }
                                    unpickedProductions.get(Q).getImgv_unpickedProduction().setImage(null);
                                    unpickedProductions.remove(Q);
                                }
                                else{
                                    System.out.println("Watch out! Your storage is full");
                                }
                            }
                        }
                    } else {
                        cats.get(i).setPlace(UPRL(cats.get(i).getPlace()));
                        cats.get(i).getImgv_cat().setLayoutX(appoint_pos_x(cats.get(i).getPlace()[0])-36.0);
                        cats.get(i).getImgv_cat().setLayoutY(appoint_pos_y(cats.get(i).getPlace()[1])-36.0);
                    }
                }
                //         #حرکت گربه#
                //         #حرکت سگ#
                for (int i = 0; i < gunDogs.size(); i++) {
                    gunDogs.get(i).setPlace(UPRL(gunDogs.get(i).getPlace()));
                    gunDogs.get(i).getImgv_dog().setLayoutX(appoint_pos_x(gunDogs.get(i).getPlace()[0])-36.0);
                    gunDogs.get(i).getImgv_dog().setLayoutY(appoint_pos_y(gunDogs.get(i).getPlace()[1])-36.0);
                }
                //         #حرکت سگ#
                //         #کاهش زمان برای حذف قفس روی زمین مانده و جا نداشته#
                for (int i = 0; i < wildAnimals.size(); i++) {
                    if (wildAnimals.get(i).isCompletedCage()){
                        wildAnimals.get(i).setTimeOnGrounOnCompletedCage(wildAnimals.get(i).getTimeOnGrounOnCompletedCage()-1);
                        if (wildAnimals.get(i).getTimeOnGrounOnCompletedCage()==0){
                            wildAnimals.get(i).getImgv_wild().setImage(null);
                            wildAnimals.get(i).getImgv_cage().setImage(null);
                            wildAnimals.remove(i);
                            i--;
                        }
                    }
                }
                //         #کاهش زمان برای حذف قفس روی زمین مانده و جا نداشته#
                //         #کاهش گام قفس مانده#
                for (int i = 0; i < wildAnimals.size(); i++) {
                    if (wildAnimals.get(i).getRemainedTimeInCage()==0 && !wildAnimals.get(i).isCompletedCage()) {
                        wildAnimals.get(i).setCageStep(NagativeToZero(wildAnimals.get(i).getCageStep() - 1));
                        if (wildAnimals.get(i).getCageStep()==0)
                            wildAnimals.get(i).getImgv_cage().setImage(null);
                        else
                            wildAnimals.get(i).getImgv_cage().setImage(wildAnimals.get(i).getImgCages().get(wildAnimals.get(i).getCageStep()-1));
                    }else if(!wildAnimals.get(i).isCompletedCage()){
                        wildAnimals.get(i).setRemainedTimeInCage(wildAnimals.get(i).getRemainedTimeInCage()-1);

                }}
                //         #کاهش گام قفس مانده#
                //         #حرکت وحشی و برخورد#
                for (int i = 0; i < wildAnimals.size(); i++) {
                    if (wildAnimals.get(i).getCageStep()!=wildAnimals.get(i).getMaxCageStep()) {
                        for (int p = 0; p < wildAnimals.get(i).getSpeed(); p++) {
                            wildAnimals.get(i).setPlace(UPRL(wildAnimals.get(i).getPlace()));
                            if (wildAnimals.get(i).getCageStep()!=0){
                                wildAnimals.get(i).getImgv_cage().setLayoutX(appoint_pos_x(wildAnimals.get(i).getPlace()[0])-36.0);
                                wildAnimals.get(i).getImgv_cage().setLayoutY(appoint_pos_y(wildAnimals.get(i).getPlace()[1])-36.0);
                            }
                            wildAnimals.get(i).getImgv_wild().setLayoutX(appoint_pos_x(wildAnimals.get(i).getPlace()[0])-36.0);
                            wildAnimals.get(i).getImgv_wild().setLayoutY(appoint_pos_y(wildAnimals.get(i).getPlace()[1])-36.0);
                            for (int k = 0; k < chickens.size(); k++) {
                                int[] wildPLace = wildAnimals.get(i).getPlace();
                                int[] otherThingPlace = chickens.get(k).getPlace();
                                if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
                                    chickens.get(k).getImgv_dome().setImage(null);
                                    chickens.remove(k);
                                    k--;
                                }
                            }
                            for (int k = 0; k < turkeies.size(); k++) {
                                int[] wildPLace = wildAnimals.get(i).getPlace();
                                int[] otherThingPlace = turkeies.get(k).getPlace();
                                if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
                                    turkeies.get(k).getImgv_dome().setImage(null);
                                    turkeies.remove(k);
                                    k--;
                                }
                            }
                            for (int k = 0; k < buffalos.size(); k++) {
                                int[] wildPLace = wildAnimals.get(i).getPlace();
                                int[] otherThingPlace = buffalos.get(k).getPlace();
                                if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
                                    buffalos.get(k).getImgv_dome().setImage(null);
                                    buffalos.remove(k);
                                    k--;
                                }
                            }
                            for (int k = 0; k < cats.size(); k++) {
                                int[] wildPLace = wildAnimals.get(i).getPlace();
                                int[] otherThingPlace = cats.get(k).getPlace();
                                if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
                                    cats.get(k).getImgv_cat().setImage(null);
                                    cats.remove(k);
                                    k--;
                                }
                            }
                            for (int k = 0; k < unpickedProductions.size(); k++) {
                                int[] wildPLace = wildAnimals.get(i).getPlace();
                                int[] otherThingPlace = unpickedProductions.get(k).getPlace();
                                if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
                                    unpickedProductions.get(k).getImgv_unpickedProduction().setImage(null);
                                    unpickedProductions.remove(k);
                                    k--;
                                }
                            }
                            for (int k = 0; k < gunDogs.size(); k++) {
                                int[] wildPLace = wildAnimals.get(i).getPlace();
                                int[] otherThingPlace = gunDogs.get(k).getPlace();
                                if (wildPLace[0] == otherThingPlace[0] && wildPLace[1] == otherThingPlace[1]) {
                                    gunDogs.get(k).getImgv_dog().setImage(null);
                                    gunDogs.remove(k);
                                    wildAnimals.get(i).getImgv_cage().setImage(null);
                                    wildAnimals.get(i).getImgv_wild().setImage(null);
                                    wildAnimals.remove(i);
                                    i--;
                                    break;
                                }
                            }
                        }
                    }
                }
                //         #حرکت وحشی و برخورد#
                //         #خوردن علف#
                int[][] grasses = farm.getPosition();
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (grasses[k][l] != 0) {
                            ArrayList<DomesticAnimal> inOnePlaceToEatGrass = new ArrayList<>();
                            for (int i = 0; i < chickens.size(); i++) {
                                if (chickens.get(i).getSpanTime() <= 50) {
                                    int[] animalPlace = chickens.get(i).getPlace();
                                    if (animalPlace[0] == k + 1 && animalPlace[1] == l + 1) {
                                        inOnePlaceToEatGrass.add(chickens.get(i));
                                    }
                                }
                            }
                            for (int i = 0; i < turkeies.size(); i++) {
                                if (turkeies.get(i).getSpanTime() <= 50) {
                                    int[] animalPlace = turkeies.get(i).getPlace();
                                    if (animalPlace[0] == k+1 && animalPlace[1] == l+1) {
                                        inOnePlaceToEatGrass.add(turkeies.get(i));
                                    }
                                }
                            }
                            for (int i = 0; i < buffalos.size(); i++) {
                                if (buffalos.get(i).getSpanTime() <= 50) {
                                    int[] animalPlace = buffalos.get(i).getPlace();
                                    if (animalPlace[0] == k+1 && animalPlace[1] == l+1) {
                                        inOnePlaceToEatGrass.add(buffalos.get(i));
                                    }
                                }
                            }
                            for (int d = 0; d < grasses[k][l]; d++){
                                int atLeastSpanTime = 100;
                                int atLeastSpanTimeIndex = 0;
                                for (int i = 0; i < inOnePlaceToEatGrass.size(); i++) {
                                    if (atLeastSpanTime >= inOnePlaceToEatGrass.get(i).getSpanTime()) {
                                        atLeastSpanTime = inOnePlaceToEatGrass.get(i).getSpanTime();
                                        atLeastSpanTimeIndex = i;
                                    }
                                }
                                if (!inOnePlaceToEatGrass.isEmpty()) {
                                    inOnePlaceToEatGrass.get(atLeastSpanTimeIndex).setSpanTime(100);
                                    int[] animalTempPlace = inOnePlaceToEatGrass.get(atLeastSpanTimeIndex).getPlace();
                                    grasses[animalTempPlace[0] - 1][animalTempPlace[1] - 1]--;
                                    if (grasses[animalTempPlace[0] - 1][animalTempPlace[1] - 1]==0)
                                    farm.getImgv_farm()[animalTempPlace[0] - 1][animalTempPlace[1] - 1].setImage(null);
                                    farm.setPosition(grasses);
                                    inOnePlaceToEatGrass.remove(atLeastSpanTimeIndex);
                                }
                            }
                        }
                    }
                }
                //         #خوردن علف#
                //          #پر کردن چاه#
                if (well.isFilling()) {
                    well.setChangableFillingDuration(well.getChangableFillingDuration() - 1);
                    if (well.getChangableFillingDuration()>=1)
                    imgv_well.setImage(well.getImages().get(16-well.getChangableFillingDuration()));
                    else
                        imgv_well.setImage(well.getImages().get(well.getChangableFillingDuration()));
                    if (well.getChangableFillingDuration() == 0) {
                        wellSound.pause();
                        well.setCurrentCapacity(well.getMaxCapacity());
                        well.setChangableFillingDuration(well.getFillingDuration());
                        well.setFilling(false);
                    }
                }
                //          #پر کردن چاه#
                //*************down is inquiry
//                System.out.println(passedTime);
//                int[][] temp = farm.getPosition();
//                for (int i = 5; i >= 0; i--) {
//                    for (int j = 0; j < 6; j++) {
//                        System.out.print(temp[j][i] + " ");
//                    }
//                    System.out.println("");
//                }
//                DomesticAnimal domesticTemp = new DomesticAnimal();
//                for (int i = 0; i < chickens.size(); i++) {
//                    domesticTemp = chickens.get(i);
//                    int[] domesticTempPlace = domesticTemp.getPlace();
//                    System.out.println(domesticTemp.getName() + " " + domesticTemp.getSpanTime() + "% [" + domesticTempPlace[0] + "," + domesticTempPlace[1] + "]");
//                }
//                for (int i = 0; i < turkeies.size(); i++) {
//                    domesticTemp = turkeies.get(i);
//                    int[] domesticTempPlace = domesticTemp.getPlace();
//                    System.out.println(domesticTemp.getName() + " " + domesticTemp.getSpanTime() + "% [" + domesticTempPlace[0] + "," + domesticTempPlace[1] + "]");
//                }
//                for (int i = 0; i < buffalos.size(); i++) {
//                    domesticTemp = buffalos.get(i);
//                    int[] domesticTempPlace = domesticTemp.getPlace();
//                    System.out.println(domesticTemp.getName() + " " + domesticTemp.getSpanTime() + "% [" + domesticTempPlace[0] + "," + domesticTempPlace[1] + "]");
//                }
//                WildAnimal wildTemp = new WildAnimal();
//                for (int i = 0; i < wildAnimals.size(); i++) {
//                    wildTemp = wildAnimals.get(i);
//                    int[] wildTempPlace = wildTemp.getPlace();
//                    System.out.println(wildTemp.getName() + " " + wildTemp.getCageStep() + " [" + wildTempPlace[0] + "," + wildTempPlace[1] + "]");
//                }
//                Cat catTemp = new Cat();
//                for (int i = 0; i < cats.size(); i++) {
//                    catTemp = cats.get(i);
//                    int[] catTempPlace = catTemp.getPlace();
//                    System.out.println("Cat " + "[" + catTempPlace[0] + "," + catTempPlace[1] + "]");
//                }
//                GunDog houndTemp = new GunDog();
//                for (int i = 0; i < gunDogs.size(); i++) {
//                    houndTemp = gunDogs.get(i);
//                    int[] houndTempPlace = houndTemp.getPlace();
//                    System.out.println("Hound " + "[" + houndTempPlace[0] + "," + houndTempPlace[1] + "]");
//                }
//                UnpickedProductions unpickedProductionTemp = new UnpickedProductions();
//                for (int i = 0; i < unpickedProductions.size(); i++) {
//                    unpickedProductionTemp = unpickedProductions.get(i);
//                    System.out.println(unpickedProductionTemp.getType() + "[" + unpickedProductionTemp.getPlace_x() + "," + unpickedProductionTemp.getPlace_y() + "]");
//                }
//                for (Map.Entry me : Tasks.entrySet()) {
//                    //System.out.println(tasks[i]+": "+me.getValue()+"/"+tasks[i+1]);
//                    if ("coin".equalsIgnoreCase(String.valueOf(me.getKey()))){
//                        if (isPickedCoin){
//                            System.out.println("Coin : " + me.getValue() + "/" +me.getValue() );
//                        }
//                        else
//                            System.out.println("Coin : " + coins + "/" +me.getValue() );
//                    }
//                    else{
//                        for (int i = 0; i < tasks.length; i += 2) {
//                            if (tasks[i].equalsIgnoreCase((String) me.getKey())) {
//                                int tempForShow=Integer.parseInt(tasks[i + 1]) - Integer.parseInt(String.valueOf(me.getValue()));
//                                if (tempForShow<=Integer.parseInt(tasks[i + 1]))
//                                    System.out.println(tasks[i] + ": " + tempForShow + "/" + tasks[i + 1]);
//                                else if (tempForShow>Integer.parseInt(tasks[i + 1]))
//                                    System.out.println(tasks[i] + ": " + tasks[i + 1] + "/" + tasks[i + 1]);
//                                break;
//                            }
//                        }
//                    }
//                }
//                //  log
//                now = LocalDateTime.now();
//                PWriterlog.println("[Info]" + dtfNow.format(now) + "Use turn command");
//                //  log
//                // #turn#
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public int getPassedTime() {
        return passedTime;
    }

    public void setPassedTime(int passedTime) {
        this.passedTime = passedTime;
    }

    public Image getImg_chicken() {
        return img_chicken;
    }

    public void setImg_chicken(Image img_chicken) {
        this.img_chicken = img_chicken;
    }

    public ArrayList<DomesticAnimal> getTurkeies() {
        return turkeies;
    }

    public void setTurkeies(ArrayList<DomesticAnimal> turkeies) {
        this.turkeies = turkeies;
    }

    public MediaPlayer getWellSound() {
        return wellSound;
    }

    public void setWellSound(MediaPlayer wellSound) {
        this.wellSound = wellSound;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public ArrayList<DomesticAnimal> getBuffalos() {
        return buffalos;
    }

    public void setBuffalos(ArrayList<DomesticAnimal> buffalos) {
        this.buffalos = buffalos;
    }

    public ArrayList<DomesticAnimal> getChickens() {
        return chickens;
    }

    public void setChickens(ArrayList<DomesticAnimal> chickens) {
        this.chickens = chickens;
    }

    public ArrayList<UnpickedProductions> getUnpickedProductions() {
        return unpickedProductions;
    }

    public void setUnpickedProductions(ArrayList<UnpickedProductions> unpickedProductions) {
        this.unpickedProductions = unpickedProductions;
    }

    public ArrayList<Factory> getFactories() {
        return factories;
    }

    public void setFactories(ArrayList<Factory> factories) {
        this.factories = factories;
    }

    public int getChickenNo() {
        return chickenNo;
    }

    public void setChickenNo(int chickenNo) {
        this.chickenNo = chickenNo;
    }

    public HashMap<String, Integer> getTasks() {
        return Tasks;
    }

    public void setTasks(HashMap<String, Integer> tasks) {
        Tasks = tasks;
    }

    public ArrayList<WildAnimal> getWildAnimals() {
        return wildAnimals;
    }

    public void setWildAnimals(ArrayList<WildAnimal> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public boolean isDrivenCar() {
        return IsDrivenCar;
    }

    public void setDrivenCar(boolean drivenCar) {
        IsDrivenCar = drivenCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public boolean isPickedCoin() {
        return isPickedCoin;
    }

    public int[] getPassedTimeC() {
        return passedTimeC;
    }

    public void setPassedTimeC(int[] passedTimeC) {
        this.passedTimeC = passedTimeC;
    }

    public int[] getChickenNoO() {
        return chickenNoO;
    }

    public void setChickenNoO(int[] chickenNoO) {
        this.chickenNoO = chickenNoO;
    }

    public boolean[] getIsPickedCoinO() {
        return IsPickedCoinO;
    }

    public void setIsPickedCoinO(boolean[] isPickedCoinO) {
        IsPickedCoinO = isPickedCoinO;
    }

    public int[] getCoinO() {
        return coinO;
    }

    public void setCoinO(int[] coinO) {
        this.coinO = coinO;
    }

    public boolean[] getIsDrivenO() {
        return IsDrivenO;
    }

    public void setIsDrivenO(boolean[] isDrivenO) {
        IsDrivenO = isDrivenO;
    }

    public void setPickedCoin(boolean pickedCoin) {
        isPickedCoin = pickedCoin;
    }

    public ArrayList<String> getWildAnimalsInMission() {
        return wildAnimalsInMission;
    }

    public void setWildAnimalsInMission(ArrayList<String> wildAnimalsInMission) {
        this.wildAnimalsInMission = wildAnimalsInMission;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public ArrayList<GunDog> getGunDogs() {
        return gunDogs;
    }

    public void setGunDogs(ArrayList<GunDog> gunDogs) {
        this.gunDogs = gunDogs;
    }

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }

    public void setTasks(String[] tasks) {
        this.tasks = tasks;
    }
    public String[] getTaskS(){
        return tasks;
    }

    public AnchorPane getRootpane() {
        return rootpane;
    }

    public void setRootpane(AnchorPane rootpane) {
        this.rootpane = rootpane;
    }
    public ImageView getFrontMouse() {
        return frontMouse;
    }

    public void setFrontMouse(ImageView frontMouse) {
        this.frontMouse = frontMouse;
    }

    public ImageView getCarInRoad() {
        return carInRoad;
    }

    public void setCarInRoad(ImageView carInRoad) {
        this.carInRoad = carInRoad;
    }

    public ImageView getImgv_well() {
        return imgv_well;
    }

    public void setImgv_well(ImageView imgv_well) {
        this.imgv_well = imgv_well;
    }

    public ImageView getImgv_bakery1() {
        return imgv_bakery1;
    }

    public void setImgv_bakery1(ImageView imgv_bakery1) {
        this.imgv_bakery1 = imgv_bakery1;
    }

    public ImageView getImgv_drapery1() {
        return imgv_drapery1;
    }

    public void setImgv_drapery1(ImageView imgv_drapery1) {
        this.imgv_drapery1 = imgv_drapery1;
    }

    public ImageView getImgv_gristmill1() {
        return imgv_gristmill1;
    }

    public void setImgv_gristmill1(ImageView imgv_gristmill1) {
        this.imgv_gristmill1 = imgv_gristmill1;
    }

    public ImageView getImgv_icecream_incubator() {
        return imgv_icecream_incubator;
    }

    public void setImgv_icecream_incubator(ImageView imgv_icecream_incubator) {
        this.imgv_icecream_incubator = imgv_icecream_incubator;
    }

    public ImageView getImgv_milkboxing1() {
        return imgv_milkboxing1;
    }

    public void setImgv_milkboxing1(ImageView imgv_milkboxing1) {
        this.imgv_milkboxing1 = imgv_milkboxing1;
    }

    public ImageView getImgv_sewing1() {
        return imgv_sewing1;
    }

    public void setImgv_sewing1(ImageView imgv_sewing1) {
        this.imgv_sewing1 = imgv_sewing1;
    }
    public Text getCoin() {
        return coin;
    }
    public void setCoin(Text coin) {
        this.coin = coin;
    }

    public boolean endTasks(HashMap<String,Integer> hashMap) {

        for (Map.Entry hash : hashMap.entrySet()){
            if (Integer.parseInt(hash.getValue().toString())!=0){
                return false;
            }
        }
        return true;
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
    public int NagativeToZero(int number) {
        if (number <= 0)
            return 0;
        return number;
    }
    public int appoint_x(double x){
        if (x>=0 && x<48){
            return 1;
        }
        else if (x>=48 && x<96){
            return 2;
        }
        else if (x>=96 && x<144){
            return 3;
        }
        else if (x>=144 && x<192){
            return 4;
        }
        else if (x>=192 && x<240){
            return 5;
        }
        else if (x>=240 && x<=288){
            return 6;
        }
        return -1;
    }
    public int appoint_y(double y){
        if (y>=0 && y<31){
            return 1;
        }
        else if (y>=31 && y<62){
            return 2;
        }
        else if (y>=62 && y<93){
            return 3;
        }
        else if (y>=93 && y<124){
            return 4;
        }
        else if (y>=124 && y<155){
            return 5;
        }
        else if (y>=155 && y<=186){
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

    public void setGifted(boolean gifted) {
        isGifted = gifted;
    }
}

public class GameCenter implements Initializable {
    Turn turn ;
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
    @FXML
    private Button menu;
    @FXML
    private ImageView imgv_well=new ImageView();

    @FXML
            private ImageView frontMouse;
    @FXML
            private ImageView carInRoad;
@FXML
        private Text coin;

    Image img_chicken = new Image(new File("chicken1.png").toURI().toString());
    Image img_turkey = new Image(new File("turkey1.png").toURI().toString());
    Image img_buffalo = new Image(new File("buffalo1.png").toURI().toString());
    Image img_cat = new Image(new File("cat1.png").toURI().toString());
    Image img_dog = new Image(new File("dog1.png").toURI().toString());
    Image img_toRcar= new Image(new File("Rcar.png").toURI().toString());
    Image img_toLcar= new Image(new File("Lcar.png").toURI().toString());

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
    File AccountFile;
    //      #files#
    FileWriter Writerlog;
    BufferedWriter WBufferlog;
    PrintWriter PWriterlog;
    //CHECK_Amin**********************************
    ArrayList<WildAnimal> wildAnimals = new ArrayList<>();
    ArrayList<String> wildAnimalsInMission;
    Storage storage = new Storage();
    String[] tasks;
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

    private int[] passedTimeC = new int[1];
    private int[] chickenNoO = new int[1];
    private boolean[] IsPickedCoinO = new boolean[1];
    private int[] coinO = new int[1];
    private boolean[] IsDrivenO = new boolean[1];




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.setImplicitExit(false);
        IsPickedCoinO[0]=false;
        chickenNoO[0]=0;
        passedTimeC[0]=0;
        player_well.setCycleCount(MediaPlayer.INDEFINITE);
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
            AccountFile = new File("..\\Farm Frenzy 3(Users)/" + username + ".txt");
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
            coinO[0] = coins;
            coin.setText(String.valueOf(coins));
            wildAnimalsInMission = new ArrayList<>();
            tasks = RBuffer.readLine().split(" ");
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
            coinO[0]+=giftedCoin;
            coin.setText(String.valueOf(coins));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry task : Tasks.entrySet()){
            if("coin".equalsIgnoreCase(String.valueOf(task.getKey())))
                if (Integer.parseInt(String.valueOf(task.getValue()))<=coinO[0]){
                    isPickedCoin=true;
                    IsPickedCoinO[0]=true;
                }
        }
        imgv_well.setImage(new Image(new File("w1_1.png").toURI().toString()));
        imgv_well.toFront();
        //     #turn class#
        turn=new Turn();
        turn.setAccountFile(AccountFile);
        turn.setFarm(farm);
        turn.setPassedTime(passedTime);
        turn.setChickens(chickens);
        turn.setTurkeies(turkeies);
        turn.setBuffalos(buffalos);
        turn.setUnpickedProductions(unpickedProductions);
        turn.setFactories(factories);
        turn.setChickenNo(chickenNo);
        turn.setTasks(Tasks);
        turn.setWildAnimals(wildAnimals);
        turn.setDrivenCar(IsDrivenCar);
        turn.setCar(car);
        turn.setCoins(coins);
        turn.setPickedCoin(isPickedCoin);
        turn.setWildAnimalsInMission(wildAnimalsInMission);
        turn.setCats(cats);
        turn.setSpace(space);
        turn.setStorage(storage);
        turn.setGunDogs(gunDogs);
        turn.setWell(well);
        turn.setTasks(tasks);
        turn.setRootpane(rootPane);
        turn.setFrontMouse(frontMouse);
        turn.setCarInRoad(carInRoad);
        turn.setImgv_bakery1(imgv_bakery1);
        turn.setImgv_drapery1(imgv_drapery1);
        turn.setImgv_gristmill1(imgv_gristmill1);
        turn.setImgv_icecream_incubator(imgv_icecream_incubator);
        turn.setImgv_milkboxing1(imgv_milkboxing1);
        turn.setImgv_sewing1(imgv_sewing1);
        turn.setImgv_well(imgv_well);
        turn.setCoin(coin);
        turn.setWellSound(player_well);
        turn.setCoinO(coinO);
        turn.setChickenNoO(chickenNoO);
        turn.setIsDrivenO(IsDrivenO);
        turn.setPassedTimeC(passedTimeC);
        turn.setIsPickedCoinO(IsPickedCoinO);
        turn.setMaxlevel(isMaxlevel);
        turn.setGiftCoin(giftCoin);
        turn.setPass(pass);
        turn.setMaxLevel(maxLevel);
        turn.setGifted(isGifted);
        //     #turn class#
        turn.start();
    }

    public int appoint_x(double x){
        if (x>=0 && x<48){
            return 1;
        }
        else if (x>=48 && x<96){
            return 2;
        }
        else if (x>=96 && x<144){
            return 3;
        }
        else if (x>=144 && x<192){
            return 4;
        }
        else if (x>=192 && x<240){
            return 5;
        }
        else if (x>=240 && x<=288){
            return 6;
        }
        return -1;
    }
    public int appoint_y(double y){
        if (y>=0 && y<31){
            return 1;
        }
        else if (y>=31 && y<62){
            return 2;
        }
        else if (y>=62 && y<93){
            return 3;
        }
        else if (y>=93 && y<124){
            return 4;
        }
        else if (y>=124 && y<155){
            return 5;
        }
        else if (y>=155 && y<=186){
            return 6;
        }
        return -1;
    }
//    public int appoint_pos_x(int x){
//        if (x==1){
//            return 24;
//        }
//        else if (x==2){
//            return 72;
//        }
//        else if (x==3){
//            return 120;
//        }
//        else if (x==4){
//            return 168;
//        }
//        else if (x==5){
//            return 216;
//        }
//        else if (x==6){
//            return 264;
//        }
//        return -1;
//    }
//    public int appoint_pos_y(int y){
//        if (y==1){
//            return 15;
//        }
//        else if (y==2){
//            return 46;
//        }
//        else if (y==3){
//            return 77;
//        }
//        else if (y==4){
//            return 108;
//        }
//        else if (y==5){
//            return 139;
//        }
//        else if (y==6){
//            return 170;
//        }
//        return -1;
//    }
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
                        rootPane.getChildren().remove(unpickedProductions.get(i).getImgv_unpickedProduction());
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
                        rootPane.getChildren().remove(unpickedProductions.get(i).getImgv_unpickedProduction());
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

                            wildAnimals.get(i).getImgv_cage().setImage(wildAnimals.get(i).getImgCages().get(wildAnimals.get(i).getCageStep()));

                            if (wildAnimals.get(i).getCageStep()==0) {

                                int finalI = i;
                                Platform.runLater(new Runnable(){

                                    @Override
                                    public void run() {
                                        rootPane.getChildren().add(wildAnimals.get(finalI).getImgv_cage());
                                        frontMouse.toFront();
                                    }
                                });


                                wildAnimals.get(i).getImgv_cage().setLayoutX(wildAnimals.get(i).getImgv_wild().getLayoutX());
                                wildAnimals.get(i).getImgv_cage().setLayoutY(wildAnimals.get(i).getImgv_wild().getLayoutY());
                                wildAnimals.get(i).getImgv_cage().setFitHeight(wildAnimals.get(i).getImgv_wild().getFitHeight());
                                wildAnimals.get(i).getImgv_cage().setFitWidth(wildAnimals.get(i).getImgv_wild().getFitWidth());
                            }

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
                                rootPane.getChildren().remove(wildAnimals.get(i).getImgv_wild());
                                rootPane.getChildren().remove(wildAnimals.get(i).getImgv_cage());
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
                        if (!farm.isPlant(x,y)){
                            Image imgGrass =new Image(new File("grass.png").toURI().toString());
                            farm.getImgv_farm()[x-1][y-1]=new ImageView();
                            farm.getImgv_farm()[x-1][y-1].setImage(imgGrass);
                            rootPane.getChildren().add( farm.getImgv_farm()[x-1][y-1]);
                            frontMouse.toFront();
                            farm.getImgv_farm()[x-1][y-1].setLayoutX(appoint_pos_x(x)-36.0);
                            farm.getImgv_farm()[x-1][y-1].setLayoutY(appoint_pos_y(y)-36.0);
                            farm.getImgv_farm()[x-1][y-1].setFitWidth(43.0);
                            farm.getImgv_farm()[x-1][y-1].setFitHeight(43.0);
                        }

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
                    coinO[0]-= (factory.getBuildPrice()/2);
                    turn.setCoins(coins);
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
                    coinO[0]-= (factory.getBuildPrice()/2);
                    coin.setText(String.valueOf(coins));
                    turn.setCoins(coins);
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
                    coinO[0]-= (factory.getBuildPrice()/2);
                    coin.setText(String.valueOf(coins));
                    turn.setCoins(coins);
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
                    coin.setText(String.valueOf(coins));
                    turn.setCoins(coins);
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
                    coin.setText(String.valueOf(coins));
                    turn.setCoins(coins);
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
                    coin.setText(String.valueOf(coins));
                    turn.setCoins(coins);
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
                    coin.setText(String.valueOf(coins));
                    turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            frontMouse.toFront();
            player_sell_buy.play();
            player_sell_buy.seek(player_sell_buy.getStartTime());
            chickenNo++;
            chickenNoO[0]++;
            turn.setChickenNo(chickenNo);
            dome.setName(dome.getName() + chickenNoO[0]);
            chickens.add(dome);
            imgv_ch.setImage(img_chicken);
            imgv_ch.setLayoutX(appoint_pos_x(dome.getPlace()[0])-36.0);
            imgv_ch.setLayoutY(appoint_pos_y(dome.getPlace()[1])-36.0);
            imgv_ch.setFitWidth(43.0);
            imgv_ch.setFitHeight(43.0);
            dome.setImgv_dome(imgv_ch);
            //System.out.println("You have your new chicken");
            coins -= dome.getPrice();
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            frontMouse.toFront();
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            frontMouse.toFront();
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            frontMouse.toFront();
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
            frontMouse.toFront();
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
            coin.setText(String.valueOf(coins));
            turn.setCoins(coins);
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
                    turn.setCoins(coins);
                    //System.out.println(player_well.getCycleCount());
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
        if (IsDrivenO[0]) {
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
            IsDrivenO[0]=true;
            carInRoad.setImage(img_toRcar);
            turn.setDrivenCar(IsDrivenCar);
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
            else if (!IsDrivenO[0]){
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
        if (!IsDrivenO[0]){
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
                    car.loadList=new HashMap<>();
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
                    storageBox.getItems().clear();
                    truckBox.getItems().clear();
                    for (Map.Entry hash : storage.storageList.entrySet()){
                        if (Integer.parseInt(hash.getValue().toString())!=0){
                            String str1 = "";
                            str1 += (hash.getKey().toString() + " " + hash.getValue().toString());
                            storageBox.getItems().add(str1);
                        }
                    }
                    for (Map.Entry hash : car.loadList.entrySet()){
                        if (Integer.parseInt(hash.getValue().toString())!=0){
                            String str1 = "";
                            str1 += (hash.getKey().toString() + " " + hash.getValue().toString());
                            truckBox.getItems().add(str1);
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        unload_button.setOnAction( e -> {
            try {
                if (truckBox.getValue().toString().equals(null)){
                    System.out.println("Nothing selected");
                }
                else {
                    String str = "truck unload ";
                    String[] strings = truckBox.getValue().toString().split(" ");
                    str += strings[0];
                    truckUnload(str);
                    storageBox.getItems().clear();
                    truckBox.getItems().clear();
                    for (Map.Entry hash : storage.storageList.entrySet()){
                        if (Integer.parseInt(hash.getValue().toString())!=0){
                            String str1 = "";
                            str1 += (hash.getKey().toString() + " " + hash.getValue().toString());
                            storageBox.getItems().add(str1);
                        }
                    }
                    for (Map.Entry hash : car.loadList.entrySet()){
                        if (Integer.parseInt(hash.getValue().toString())!=0){
                            String str1 = "";
                            str1 += (hash.getKey().toString() + " " + hash.getValue().toString());
                            truckBox.getItems().add(str1);
                        }
                    }
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

    //  pause
    public void showMenu() throws IOException{
        menu.setOnAction(null);
        turn.suspend();
        imgv_truck.setOnMouseClicked(null);
        ImageView imgv_menu = new ImageView();
        Image img_menu = new Image(new File("menu1.png").toURI().toString());
        imgv_menu.setImage(img_menu);
        Button resume = new Button("Resume");
        Button menu1 = new Button("Menu");
        resume.setLayoutX(300);
        resume.setLayoutY(75);
        menu1.setLayoutX(300);
        menu1.setLayoutY(300);
        imgv_menu.setLayoutX(115);
        imgv_menu.setLayoutY(25);
        resume.setOnAction( e -> {
            menu.setOnAction( e1 -> {
                try {
                    showMenu();
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
            rootPane.getChildren().removeAll(imgv_menu,resume,menu1);
            turn.resume();
        });
        menu1.setOnAction(event -> {
            turn.getMediaPlayer().pause();
            File file = new File("name.txt");
            try {
                FileWriter fileWriter = new FileWriter(file,true);
                WBuffer=new BufferedWriter(fileWriter);
                PWriter=new PrintWriter(WBuffer);
                PWriter.println(username);
                PWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Main main = new Main();
            try {
                main.changingScene("Level.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        rootPane.getChildren().addAll(imgv_menu,resume,menu1);
    }
    //  pause


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
