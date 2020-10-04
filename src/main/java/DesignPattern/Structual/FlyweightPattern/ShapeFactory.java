package DesignPattern.Structual.FlyweightPattern;

import java.util.HashMap;

/**
 * 3 创建一个工厂，生成基于给定信息的实体类的对象
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color){

        // 相同颜色的circle对象，只会被创建一份
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null){
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circleof color : " + color);
        }
        return circle;
    }
}
