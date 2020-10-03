package DesignPattern.Structual.BridgePattern;

/**
 * 创建实现了DrawAPI接口的实体桥接 实现类
 */
public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.printf("Drawing Circle [color: red, radius: %s, x: %s, y:%s \n", radius, x, y);
    }
}
