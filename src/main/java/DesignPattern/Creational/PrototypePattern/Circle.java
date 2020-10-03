package DesignPattern.Creational.PrototypePattern;

/**
 * 创建扩展抽象类的实体类
 */
public class Circle extends Shape{

    public Circle(){
        type = "Cicrcle";
    }

    @Override
    public void draw(){
        System.out.println("Inside Cicrcle::draw() method.");
    }
}
