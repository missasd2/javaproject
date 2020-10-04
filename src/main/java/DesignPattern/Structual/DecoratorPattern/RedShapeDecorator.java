package DesignPattern.Structual.DecoratorPattern;

/**
 * 4 扩展了ShapeDecorator类的实体装饰类
 */
public class RedShapeDecorator extends ShapeDecorator {
public RedShapeDecorator(Shape decoratedShape){
    super(decoratedShape);
}


    @Override
    public void draw() {
        super.draw();
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color : Red");
    }
}
