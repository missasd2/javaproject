package JavaSE.DataType;

public class TestBasicType {

    public static void main(String[] args) {
        Integer wan = new Integer(100);
        Integer che = new Integer(100);
        System.out.println(wan == che);
        System.out.println(wan.equals(che));

        // 自动装箱中的缓存
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false
    }
}
