package sample;

import javafx.scene.image.Image;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Factory {
    private String fName;
    private String inputProduction;
    private String outputProduction;
    private int productionTime;
    private int changableProductionTime;
    private int buildPrice;
    private int level = 1;
    private boolean exist ;
    private boolean working = false;
    private ArrayList<Image> images1 =new ArrayList<>();
    private ArrayList<Image> images2 =new ArrayList<>();


    public Factory(String fName) {
        this.fName = fName;
        this.working = false;
        this.exist = true;
        if (fName.equalsIgnoreCase("gristmill")){
            this.inputProduction = "egg";
            this.outputProduction = "flour";
            this.buildPrice = 150;
            this.productionTime = 4;
            this.changableProductionTime=4;
            this.images1.add(new Image(new File("g1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("g1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("g2_16.png").toURI().toString()));

        }
        else if (fName.equalsIgnoreCase("drapery")){
            this.inputProduction = "feather";
            this.outputProduction = "cloth";
            this.buildPrice = 250;
            this.productionTime = 5;
            this.changableProductionTime=5;
            this.images1.add(new Image(new File("d1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("d1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("d2_16.png").toURI().toString()));
        }
        else if (fName.equalsIgnoreCase("milkBoxing")){
            this.inputProduction = "milk";
            this.outputProduction = "box";
            this.buildPrice = 400;
            this.productionTime = 6;
            this.changableProductionTime=6;
            this.images1.add(new Image(new File("m1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("m1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("m2_16.png").toURI().toString()));
        }
        else if (fName.equalsIgnoreCase("bakery")){
            this.inputProduction = "flour";
            this.outputProduction = "bread";
            this.buildPrice = 250;
            this.productionTime = 5;
            this.changableProductionTime=5;
            this.images1.add(new Image(new File("b1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("b1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("b2_16.png").toURI().toString()));
        }
        else if (fName.equalsIgnoreCase("sewing")){
            this.inputProduction = "cloth";
            this.outputProduction = "shirt";
            this.buildPrice = 400;
            this.productionTime = 6;
            this.changableProductionTime=6;
            this.images1.add(new Image(new File("s1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("s1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("s2_16.png").toURI().toString()));
        }
        else if (fName.equalsIgnoreCase("iceCream")){
            this.inputProduction = "box";
            this.outputProduction = "iceCream";
            this.buildPrice = 550;
            this.productionTime = 7;
            this.changableProductionTime=7;
            this.images1.add(new Image(new File("ic1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("ic1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("ic2_16.png").toURI().toString()));
        }
        else if (fName.equalsIgnoreCase("incubator")){
            this.inputProduction = "egg";
            this.outputProduction = "chicken";
            this.buildPrice = 600;
            this.productionTime = 9;
            this.changableProductionTime=9;
            this.images1.add(new Image(new File("in1_1.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_2.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_3.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_4.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_5.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_6.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_7.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_8.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_9.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_10.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_11.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_12.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_13.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_14.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_15.png").toURI().toString()));
            this.images1.add(new Image(new File("in1_16.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_1.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_2.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_3.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_4.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_5.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_6.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_7.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_8.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_9.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_10.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_11.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_12.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_13.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_14.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_15.png").toURI().toString()));
            this.images2.add(new Image(new File("in2_16.png").toURI().toString()));
        }
    }

    public void upgrade() throws IOException {
        if (this.level==1){

            this.level++;
            if (this.productionTime % 2 == 0) {
                if (this.changableProductionTime == productionTime)
                    this.changableProductionTime /= 2;
                this.productionTime /= 2;
            } else {
                if (this.changableProductionTime == productionTime) {
                    this.changableProductionTime /= 2;
                    this.changableProductionTime++;
                }
                this.productionTime /= 2;
                this.productionTime++;
            }
        }
        else{
            System.out.println("You only can upgrade factory once!");
            File Whatsup = new File("..\\log.txt");
            FileWriter Writerlog;
            BufferedWriter WBufferlog;
            PrintWriter PWriterlog;
            Writerlog = new FileWriter(Whatsup, true);
            WBufferlog = new BufferedWriter(Writerlog);
            PWriterlog = new PrintWriter(WBufferlog);
            LocalDateTime now;
            DateTimeFormatter dtfNow = DateTimeFormatter.ofPattern(", yy/MM/dd _ HH:mm:ss, ");
            //  log
            now = LocalDateTime.now();
            PWriterlog.println("[Error]" + dtfNow.format(now) + "Upgrade again");
            PWriterlog.close();
            //  log
        }
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getInputProduction() {
        return inputProduction;
    }

    public void setInputProduction(String inputProduction) {
        this.inputProduction = inputProduction;
    }

    public String getOutputProduction() {
        return outputProduction;
    }

    public void setOutputProduction(String outputProduction) {
        this.outputProduction = outputProduction;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public int getBuildPrice() {
        return buildPrice;
    }

    public void setBuildPrice(int buildPrice) {
        this.buildPrice = buildPrice;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getChangableProductionTime() {
        return changableProductionTime;
    }

    public void setChangableProductionTime(int changableProductionTime) {
        this.changableProductionTime = changableProductionTime;
    }

    public ArrayList<Image> getImages1() {
        return images1;
    }

    public void setImages1(ArrayList<Image> images1) {
        this.images1 = images1;
    }

    public ArrayList<Image> getImages2() {
        return images2;
    }

    public void setImages2(ArrayList<Image> images2) {
        this.images2 = images2;
    }
}
