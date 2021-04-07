package jvm.chp7.p1;

/**
 * 代码清单7-1 通过数组定义来引用类，不会触发此类的初始化（被动引用）
 */
class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}

