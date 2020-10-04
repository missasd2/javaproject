package DesignPattern.Structual.DecoratorPattern;

/**
 * 3 实现了Shape接口的抽象装饰类
 */
public abstract class ShapeDecorator implements Shape{

    protected Shape decorateShape;

    public ShapeDecorator(Shape decorateShape){
        this.decorateShape = decorateShape;
    }

    @Override
    public void draw() {
        decorateShape.draw();
    }
}
