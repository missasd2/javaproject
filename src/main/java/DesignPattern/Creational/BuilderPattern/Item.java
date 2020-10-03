package DesignPattern.Creational.BuilderPattern;

/**
 * 表示食物的接口
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
