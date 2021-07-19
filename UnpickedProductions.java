package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class UnpickedProductions {
    private String type;

    public int[] getPlace() {
        return place;
    }

    private int[] place = new int[2];
    private boolean picked = false;
    private int unpickedTime;
    private int changableUnpickedTime;
    private ImageView imgv_unpickedProduction = new ImageView();

    public UnpickedProductions(String type, int place1 , int place2) {
        this.type = type;
        this.place[0] = place1;
        this.place[1] = place2;
        if (type.equalsIgnoreCase("egg")){
            this.unpickedTime=4;
            this.changableUnpickedTime=4;
            this.imgv_unpickedProduction.setImage(new Image(new File("egg.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("feather")){
            this.unpickedTime=4;
            this.changableUnpickedTime=4;
            this.imgv_unpickedProduction.setImage(new Image(new File("feather.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("milk")){
            this.unpickedTime=4;
            this.changableUnpickedTime=4;
            this.imgv_unpickedProduction.setImage(new Image(new File("milk.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("flour")){
            this.unpickedTime=5;
            this.changableUnpickedTime=5;
            this.imgv_unpickedProduction.setImage(new Image(new File("flour.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("cloth")){
            this.unpickedTime=5;
            this.changableUnpickedTime=5;
            this.imgv_unpickedProduction.setImage(new Image(new File("cloth.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("box")){
            this.unpickedTime=5;
            this.changableUnpickedTime=5;
            this.imgv_unpickedProduction.setImage(new Image(new File("box.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("bread")){
            this.unpickedTime=6;
            this.changableUnpickedTime=6;
            this.imgv_unpickedProduction.setImage(new Image(new File("bread.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("shirt")){
            this.unpickedTime=6;
            this.changableUnpickedTime=6;
            this.imgv_unpickedProduction.setImage(new Image(new File("shirt.png").toURI().toString()));
        }
        else if (type.equalsIgnoreCase("iceCream")){
            this.unpickedTime=6;
            this.changableUnpickedTime=6;
            this.imgv_unpickedProduction.setImage(new Image(new File("icecream.png").toURI().toString()));
        }
    }

    public UnpickedProductions() {

    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlace_x() {
        return place[0];
    }
    public int getPlace_y() {
        return place[1];
    }
    public void setPlace(int[] place) {
        this.place = place;
    }

    public int getChangableUnpickedTime() {
        return changableUnpickedTime;
    }

    public void setChangableUnpickedTime(int changableUnpickedTime) {
        this.changableUnpickedTime = changableUnpickedTime;
    }

    public ImageView getImgv_unpickedProduction() {
        return imgv_unpickedProduction;
    }

    public void setImgv_unpickedProduction(ImageView imgv_unpickedProduction) {
        this.imgv_unpickedProduction = imgv_unpickedProduction;
    }
}
