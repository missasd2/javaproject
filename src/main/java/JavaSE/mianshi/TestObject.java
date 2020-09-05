package JavaSE.mianshi;

import JavaSE.util.Abstract_Inteface.People;
import JavaSE.util.Abstract_Inteface.Teacher;

public class TestObject {

    public static void testAssign(){
        Teacher t1 = new Teacher();
        t1.setName("Peter");
    // java中赋值是复制对象引用，因此返回true
        // t1 和 t2 引用的是同一个对象
        Teacher t2 = t1;
        System.out.println(t2 == t1);
        t2.setName("tom");
        System.out.println(t1.getName());
    }

    // 获得对象的副本，可以使用clone()方法


    public static void main(String[] args) {
        testAssign();
    }

}
