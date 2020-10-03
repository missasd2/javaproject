package DesignPattern.Creational.BuilderPattern;

/**
 * 实际的builder类负责创建Meal对象
 */
public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.additem(new VegBurger());
        meal.additem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.additem(new ChickenBurger());
        meal.additem(new Pepsi());
        return meal;
    }
}
