package jvm.chp7.p1;


class SubClass extends SuperClass {
    /**
     * 静态代码块在类的初始化阶段执行
     */
    static {
        System.out.println("SubClass init!");
    }
    public static int value = 456;
}
