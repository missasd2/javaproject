package DesignPattern.Singleton.Test;

public class LanHan_Unsafe {

    private static LanHan_Unsafe instance;

    private LanHan_Unsafe(){}

    public static LanHan_Unsafe getInstance(){
        if (instance == null){
            instance = new LanHan_Unsafe();
        }
        return instance;
    }
}
