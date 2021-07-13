package sample;

import java.util.Random;

public class GunDog {
    private int price =100 ;
    private int[] place = new int[2];
    private int number;
    private boolean exist ;

    public GunDog() {
        Random rand = new Random();
        this.place[0] = rand.nextInt(6)+1;
        this.place[1] = rand.nextInt(6)+1;
        this.exist = true;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void upgrade(){

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int[] getPlace() {
        return place;
    }

    public void setPlace(int[] place) {
        this.place = place;
    }
}
