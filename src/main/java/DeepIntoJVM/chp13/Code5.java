package DeepIntoJVM.chp13;

/**
 *
 *
 *
 *
 *
 */
public class Code5 {
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = new String("Hello World");
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(1 == 1); // true
//        System.out.println(1.equals(1));
    }
}
