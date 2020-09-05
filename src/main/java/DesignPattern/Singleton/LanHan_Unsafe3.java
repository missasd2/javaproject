package DesignPattern.Singleton;

public class LanHan_Unsafe3 {
    private static LanHan_Unsafe3 instance;

    private LanHan_Unsafe3(){}

    public static LanHan_Unsafe3 getInstance(){
        if (instance == null){
            instance = new LanHan_Unsafe3();
        }
        return instance;
    }
}
