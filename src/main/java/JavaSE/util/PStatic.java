package JavaSE.util;

import java.util.HashMap;
import java.util.Map;

public class PStatic {

    // final 修饰变量表示变量不可被重新赋值，static表示这是一个类变量
    private static final String GENERAL_MAN = "man";

    // 实例变量
    private String name;

    // 静态变量
    private static int eyeNum;

    // 静态变量
    public  int legNum =2;

    // 实例方法
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    // 静态方法（类方法）
    public static int getEyeNum(){
        return eyeNum;
    }

    public static void setEyeNum(int eyeNum){
        PStatic.eyeNum = eyeNum;
        // name = "123" 静态方法只能访问静态成员（变量、方法）
    }

    public void test(int eyeNum){
        PStatic.eyeNum = eyeNum;
        this.legNum = 2;
    }

    public static Map<String, String> timeTypes;

    // 静态代码块,在加载一个类的时候最先执行，且只执行一次
    static {
        timeTypes = new HashMap<>();
        timeTypes.put("year", "年");
        timeTypes.put("quarter", "季");
        timeTypes.put("month", "月");
        timeTypes.put("day", "日");
        System.out.println(timeTypes);

    }

    public static void main(String[] args) {
        PStatic pStatic = new PStatic();
        // 类变量所所有对象共享的，一个对象对类变量值的该表，就会产生全局的影响
        System.out.println(PStatic.eyeNum);
        // 访问静态变量 推荐使用 类名.静态变量名 的方式进行访问
        pStatic.setEyeNum(25);

        PStatic pStatic1 = new PStatic();
        pStatic1.setEyeNum(28);

        System.out.println(PStatic.eyeNum);
        System.out.println(GENERAL_MAN);
        System.out.println("================");
        // 测试静态方法
        PStatic.setEyeNum(12);
        System.out.println(PStatic.eyeNum); // 12
        // 测试非静态方法
        PStatic pStatic2 = new PStatic();
        pStatic2.test(15);
        System.out.println(pStatic2.legNum);


    }
}
