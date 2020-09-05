package DesignPattern.Singleton.Test;

public class LanHan_Safe {

    private static LanHan_Safe instance;

    private LanHan_Safe(){}

    public static synchronized LanHan_Safe getInstance(){
        if (instance == null){
            instance = new LanHan_Safe();
        }
        return instance;
    }
}
