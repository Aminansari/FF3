package sample;

public class Farm {
    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    private int[][] position = new int[6][6];

    public Farm(int x , int y) {
        this.position[x-1][y-1]++ ;
    }

    public Farm() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                position[i][j] = 0;
            }
        }
    }

    public boolean isPlant(int x , int y) {
        if (this.position[x-1][y-1]>0){
            return true;
        }
        else {
            return false;
        }
    }

    public void setPlant(int x , int y) {
        this.position[x-1][y-1]++;
    }
}
