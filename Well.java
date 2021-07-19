package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class Well {
    private int maxCapacity =500;
    private int currentCapacity;
    private boolean isFilling;
    private int fillingDuration;
    private int changableFillingDuration;
    private ArrayList<Image> images =new ArrayList<>();

    public Well(int currentCapacity) {
        this.currentCapacity = currentCapacity;
        this.isFilling=false;
        this.fillingDuration=16;
        this.changableFillingDuration=16;
        this.images.add(new Image(new File("w1_1.png").toURI().toString()));
        this.images.add(new Image(new File("w1_2.png").toURI().toString()));
        this.images.add(new Image(new File("w1_3.png").toURI().toString()));
        this.images.add(new Image(new File("w1_4.png").toURI().toString()));
        this.images.add(new Image(new File("w1_5.png").toURI().toString()));
        this.images.add(new Image(new File("w1_6.png").toURI().toString()));
        this.images.add(new Image(new File("w1_7.png").toURI().toString()));
        this.images.add(new Image(new File("w1_8.png").toURI().toString()));
        this.images.add(new Image(new File("w1_9.png").toURI().toString()));
        this.images.add(new Image(new File("w1_10.png").toURI().toString()));
        this.images.add(new Image(new File("w1_11.png").toURI().toString()));
        this.images.add(new Image(new File("w1_12.png").toURI().toString()));
        this.images.add(new Image(new File("w1_13.png").toURI().toString()));
        this.images.add(new Image(new File("w1_14.png").toURI().toString()));
        this.images.add(new Image(new File("w1_15.png").toURI().toString()));
        this.images.add(new Image(new File("w1_16.png").toURI().toString()));

    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getChangableFillingDuration() {
        return changableFillingDuration;
    }

    public void setChangableFillingDuration(int changableFillingDuration) {
        this.changableFillingDuration = changableFillingDuration;
    }

    public boolean isFilling() {
        return isFilling;
    }

    public void setFilling(boolean filling) {
        isFilling = filling;
    }

    public int getFillingDuration() {
        return fillingDuration;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
