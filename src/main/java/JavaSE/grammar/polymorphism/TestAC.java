package JavaSE.grammar.polymorphism;

public class TestAC extends ClassA{
    TestAC(){
        super("B");
        System.out.println("B");
    }

    public static void main(String[] args) {
        new TestAC();
        // NumberFormatException
        // System.out.println(Integer.parseInt("123456a"));
        String str = "";
        System.out.println(str.split(",").length); // 1
        int[] a = {1,2,3,4,5};
        for (int i : a){
            System.out.print(i+"");
        }
        // =================
        System.out.println("=================");
        String s = "hello";
        String t = "hello";
        char c[] = {'h','e','l','l','o'};
        System.out.println(s.equals(t)); // true
        System.out.println(t.equals(c)); // false
        System.out.println(s==t); // true
        System.out.println(t.equals(new String("hello"))); // true
        //  Integer中的-128到127这256个数是进行缓存的，所以s==t返回true
        Integer m = Integer.parseInt("10");
        Integer n = Integer.parseInt("10");
        System.out.println(m == n); // true
        System.out.println(m.equals(n)); // true
        Integer p = Integer.parseInt("300");
        Integer q = Integer.parseInt("300");
        System.out.println(p == q); // false
        System.out.println(p.equals(q)); // true
    }
}
