package DesignPattern.Singleton;

public class Register_StaticInner1 {

    private static class Register_StaticInner1_Holder{
        private static final Register_StaticInner1 INSTANCE = new Register_StaticInner1();
    }

    private Register_StaticInner1(){};

    public static final Register_StaticInner1 getInstance(){
        return Register_StaticInner1_Holder.INSTANCE;
    }
}
