package DesignPattern.Constructual.Decorator;

/**
 * 抽象装饰类;
 *  实现了Shape接口
 *  实例变量引用了Shape对象
 */
public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
