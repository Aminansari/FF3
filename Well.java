package sample;

public class Well {
    private int maxCapacity =500;
    private int currentCapacity;
    private boolean isFilling;
    private int fillingDuration;
    private int changableFillingDuration;

    public Well(int currentCapacity) {
        this.currentCapacity = currentCapacity;
        this.isFilling=false;
        this.fillingDuration=3;
        this.changableFillingDuration=3;
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
}
