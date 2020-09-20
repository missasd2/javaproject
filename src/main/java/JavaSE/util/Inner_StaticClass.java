package JavaSE.util;

import groovy.json.JsonOutput;
import java.util.*;
public class Inner_StaticClass {
    private String str0 = "hi"; // 实例变量、非静态变量
    private static String str1 = "hello"; // 静态变量

    // 静态内部类
    static class StaticInnerClass{
        // 静态内部类可以定义静态变量、也可以定普通变量
        private String str3 = "world";
        private static String str4 = "!";

        public void getMessage(){
            // 内部类可以调用外部类的静态成员，不能调用外部类的普通成员
            // System.out.println(str0);
            System.out.println(str1);
            // 静态内部类创建外部类的实例，然后调用外部类的实例方法
            Inner_StaticClass inner_staticClass = new Inner_StaticClass();
            System.out.println(inner_staticClass.str0);
        }

        // 内部类的静态方法，通过内部类的实例调用内部类的非静态方法
        public static void testMessage(){
            System.out.println("===========");
            System.out.println(str1);
            System.out.println(str4);
            StaticInnerClass staticInnerClass = new StaticInnerClass();
            staticInnerClass.getMessage();
            System.out.println("===============");
        }
    }
    // 非静态内部类不能定义静态变量和方法
    class NoStaticInnerClass{
//        private static String name;
//        public static void getM(){
//
//        }
        // 非静态内部类可调用外部类的 静态成员和非静态成员
        // 可定义非静态方法
        public void getM(){
            System.out.println(str0);
            System.out.println(str1);
        }
    }

    // 静态代码块
    static {
        StaticInnerClass.testMessage();
    }

    public static void main(String[] args) {
        // 创建静态内部类实例
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        // 调用静态内部类的非静态方法（实例方法）
        staticInnerClass.getMessage();

        int n = 8;
        System.out.println((n & n-1) == 0) ;


    }

}
