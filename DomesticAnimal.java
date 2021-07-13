package sample;

import java.util.Random;

public class DomesticAnimal {
    private int spanTime;
    private int price;
    private int produceTime;
    private int changableProduceTime;
    private int number;
    private String production;
    private String name;
    private int[] place = new int[2];
    private boolean exist ;


    public DomesticAnimal(String name) {
        Random rand = new Random();
        this.place[0] = rand.nextInt(6)+1;
        this.place[1] = rand.nextInt(6)+1;
        this.name = name;
        this.spanTime = 100;
        this.exist = true;
        if (name.equalsIgnoreCase("chicken")){
            this.price = 100;
            this.produceTime = 2;
            this.changableProduceTime = 2;
            this.production = "egg";
        }
        else if (name.equalsIgnoreCase("turkey")){
            this.price = 200;
            this.produceTime = 3;
            this.changableProduceTime = 3;
            this.production = "feather";
        }
        else if (name.equalsIgnoreCase("buffalo")){
            this.price = 400;
            this.produceTime = 5;
            this.changableProduceTime = 5;
            this.production = "milk";
        }
    }

    public DomesticAnimal() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void goingdie(){
        this.spanTime -= (this.spanTime/10);
    }
    public int getSpanTime() {
        return spanTime;
    }

    public void setSpanTime(int spanTime) {
        this.spanTime = spanTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(int produceTime) {
        this.produceTime = produceTime;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPlace() {
        return place;
    }

    public void setPlace(int x , int y) {
        this.place = place;
    }

    public int getChangableProduceTime() {
        return changableProduceTime;
    }

    public void setChangableProduceTime(int changableProduceTime) {
        this.changableProduceTime = changableProduceTime;
    }

    public void setPlace(int[] place) {
        this.place = place;
    }
}
