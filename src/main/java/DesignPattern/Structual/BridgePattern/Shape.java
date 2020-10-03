package DesignPattern.Structual.BridgePattern;

/**
 * 使用DrawAPI接口创建Shape抽象类
 */
public abstract class Shape {

    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
