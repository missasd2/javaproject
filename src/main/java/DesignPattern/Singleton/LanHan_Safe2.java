package DesignPattern.Singleton;

public class LanHan_Safe2 {

    private static LanHan_Safe2 instance;

    private LanHan_Safe2(){}

    public static synchronized LanHan_Safe2 getInstance(){
        if (instance == null){
            instance = new LanHan_Safe2();
        }
        return instance;
    }
}
