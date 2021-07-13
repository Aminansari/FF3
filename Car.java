package sample;

import java.util.HashMap;

public class Car {
    private int space=0 ;
    private int maxSpace=15;
    private int sellDuration=10;
    private int changableSellDuration=10;
    private int sellCoins=0;
    public HashMap<String, Integer> loadList= new HashMap<>();

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

    public int getSellDuration() {
        return sellDuration;
    }

    public void setSellDuration(int sellDuration) {
        this.sellDuration = sellDuration;
    }

    public int getSellCoins() {
        return sellCoins;
    }

    public void setSellCoins(int sellCoins) {
        this.sellCoins = sellCoins;
    }

    public int getChangableSellDuration() {
        return changableSellDuration;
    }

    public void setChangableSellDuration(int changableSellDuration) {
        this.changableSellDuration = changableSellDuration;
    }
}
