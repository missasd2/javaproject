package jvm.chp7.p1;

/**
 * 代码清单7-3  常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，不会触发此类的初始化（被动引用）
 */
class NotInitialization3 {
    public static void main(String[] args) {

        System.out.println(ConstClass.HELLOWORLD);
    }
}

