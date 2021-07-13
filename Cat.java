package sample;

import java.util.Random;

public class Cat {
    private int price = 150;
    private int[] place = new int[2];
    private int number;
    private boolean exist ;

    public Cat() {
        Random rand = new Random();
        this.place[0] = rand.nextInt(6)+1;
        this.place[1] = rand.nextInt(6)+1;
        this.exist = true;
    }

    public void upgrade(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
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
