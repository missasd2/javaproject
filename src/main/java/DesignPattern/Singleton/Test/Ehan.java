package DesignPattern.Singleton.Test;

public class Ehan {

    private static Ehan instance = new Ehan();

    private Ehan(){}

    public static Ehan getInstance(){

        return instance;
    }
}
