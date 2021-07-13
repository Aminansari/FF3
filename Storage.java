package sample;

import java.util.HashMap;

public class Storage {
    private int space=0;
    private int maxSpace=30;
    public HashMap<String, Integer> storageList=new HashMap<>();

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(int maxSpace) {
        this.maxSpace = maxSpace;
    }
}
