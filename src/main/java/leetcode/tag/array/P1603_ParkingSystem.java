package leetcode.tag.array;

public class P1603_ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public P1603_ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch(carType){
            case 1:
                if(big > 0){
                    big -= 1;
                    return true;
                } else {
                    return false;
                }
            case 2:
                if(medium > 0) {
                    medium -= 1;
                    return true;
                } else {
                    return false;
                }
            case 3:
                if(small > 0) {
                    small -= 1;
                    return true;
                } else {
                    return false;
                }
            default: return false;
        }

    }

}
