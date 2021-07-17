package sample;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        }
        else if (fName.equalsIgnoreCase("drapery")){
            this.inputProduction = "feather";
            this.outputProduction = "cloth";
            this.buildPrice = 250;
            this.productionTime = 5;
            this.changableProductionTime=5;
        }
        else if (fName.equalsIgnoreCase("milkBoxing")){
            this.inputProduction = "milk";
            this.outputProduction = "box";
            this.buildPrice = 400;
            this.productionTime = 6;
            this.changableProductionTime=6;
        }
        else if (fName.equalsIgnoreCase("bakery")){
            this.inputProduction = "flour";
            this.outputProduction = "bread";
            this.buildPrice = 250;
            this.productionTime = 5;
            this.changableProductionTime=5;
        }
        else if (fName.equalsIgnoreCase("sewing")){
            this.inputProduction = "cloth";
            this.outputProduction = "shirt";
            this.buildPrice = 400;
            this.productionTime = 6;
            this.changableProductionTime=6;
        }
        else if (fName.equalsIgnoreCase("iceCream")){
            this.inputProduction = "box";
            this.outputProduction = "iceCream";
            this.buildPrice = 550;
            this.productionTime = 7;
            this.changableProductionTime=7;
        }
        else if (fName.equalsIgnoreCase("incubator")){
            this.inputProduction = "egg";
            this.outputProduction = "chicken";
            this.buildPrice = 600;
            this.productionTime = 9;
            this.changableProductionTime=9;
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
}
