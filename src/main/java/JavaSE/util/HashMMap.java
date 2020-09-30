package JavaSE.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class HashMMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Hashtable<Integer, Integer> table = new Hashtable<>();
        HashSet<Integer> set = new HashSet<>();
        Integer i = new Integer(1);
        System.out.println(i.hashCode()); // 1
        int ha = i.hashCode();
        // ^ 异或运算
        int i1 = ha ^ (ha >>> 16);
        System.out.println(ha >>> 16);
        System.out.println(i1);


    }
}
