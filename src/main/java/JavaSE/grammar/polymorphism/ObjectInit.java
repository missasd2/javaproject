package JavaSE.grammar.polymorphism;
// 表示子类
public class ObjectInit extends SuperClass{

    private static String STR = "Sub Class static variable";

    static {
        System.out.println("Class Static Block " + STR);
    }

    public ObjectInit(){
        System.out.println("Sub Constructor Method");
    }

    {
        System.out.println("Sub Class Block");
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
                ObjectInit a = new ObjectInit();

        System.out.println(-12%-5); // -2
    }
}
