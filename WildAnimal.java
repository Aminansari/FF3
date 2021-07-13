package sample;

import java.util.Random;

public class WildAnimal {
    private String name ;
    private int speed;
    private int cageStep=0;
    private int maxCageStep;
    private int[] place = new int[2];
    private int remainedTimeInCage=1;
    private boolean completedCage=false;
    private int timeOnGrounOnCompletedCage=5;

    public WildAnimal(String name) {
        this.name = name;
        Random random=new Random();
        this.place= new int[]{random.nextInt(6) + 1, random.nextInt(6) + 1};
        if (name.equalsIgnoreCase("lion")){
            this.speed=1;
            this.maxCageStep=3;
        }
        else if (name.equalsIgnoreCase("bear")){
            this.speed=1;
            this.maxCageStep=4;
        }
        else if (name.equalsIgnoreCase("tiger")){
            this.speed=2;
            this.maxCageStep=4;
        }
    }

    public WildAnimal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCageStep() {
        return cageStep;
    }

    public void setCageStep(int cageStep) {
        this.cageStep = cageStep;
    }

    public int getMaxCageStep() {
        return maxCageStep;
    }

    public void setMaxCageStep(int maxCageStep) {
        this.maxCageStep = maxCageStep;
    }

    public int[] getPlace() {
        return place;
    }

    public void setPlace(int[] place) {
        this.place = place;
    }

    public int getRemainedTimeInCage() {
        return remainedTimeInCage;
    }

    public void setRemainedTimeInCage(int remainedTimeInCage) {
        this.remainedTimeInCage = remainedTimeInCage;
    }

    public boolean isCompletedCage() {
        return completedCage;
    }

    public void setCompletedCage(boolean completedCage) {
        this.completedCage = completedCage;
    }

    public int getTimeOnGrounOnCompletedCage() {
        return timeOnGrounOnCompletedCage;
    }

    public void setTimeOnGrounOnCompletedCage(int timeOnGrounOnCompletedCage) {
        this.timeOnGrounOnCompletedCage = timeOnGrounOnCompletedCage;
    }
}
