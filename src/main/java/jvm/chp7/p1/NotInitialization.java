package jvm.chp7.p1;

/**
 * 代码清单7-1 通过子类引用父类的静态字段（被动引用）
 */
class NotInitialization {
    public static void main(String[] args) {
        /**
         * 虽然通过子类引用父类的静态字段，但并不会触发子类的初始化动作
         * 而是触发定义该静态字段的类，也就是当前类的父类的初始化动作
         * 因此执行了父类的静态代码块
         */
        System.out.println(SubClass.value);
    }
}

