package DesignPattern.Structual.BridgePattern;

public class GreenCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Drawing Circle[ color: green, radius: %s, x: %s, y: %s \n", radius, x, y);
    }
}
