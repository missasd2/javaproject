package DesignPattern.Structual.DecoratorPattern;

public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Circle circle = new Circle();

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle of red border");

        System.out.println("Rectangle of red border");
        redRectangle.draw();

    }
}
