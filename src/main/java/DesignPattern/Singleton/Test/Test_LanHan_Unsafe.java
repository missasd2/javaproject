package DesignPattern.Singleton.Test;

import DesignPattern.Singleton.LanHan_Unsafe3;

public class Test_LanHan_Unsafe {

    public static void main(String[] args) {

        LanHan_Unsafe3 instance = LanHan_Unsafe3.getInstance();
        System.out.println(instance);
    }
}
