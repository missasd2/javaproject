package DesignPattern.Creational.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Meal类带有上面定义的Item对象
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void additem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items){
            System.out.print("Item : " + item.name());
            System.out.println(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
