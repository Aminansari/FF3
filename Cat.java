package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class Cat {
    private int price = 150;
    private int[] place = new int[2];
    private int number;
    private boolean exist ;
    @FXML
    ImageView imgv_cat = new ImageView();

    public Cat() {
        Random rand = new Random();
        this.place[0] = rand.nextInt(6)+1;
        this.place[1] = rand.nextInt(6)+1;
        this.exist = true;
    }

    public ImageView getImgv_cat() {
        return imgv_cat;
    }

    public void setImgv_cat(ImageView imgv_cat) {
        this.imgv_cat = imgv_cat;
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
