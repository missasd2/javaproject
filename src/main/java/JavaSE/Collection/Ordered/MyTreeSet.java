package JavaSE.Collection.Ordered;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MyTreeSet {

    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            int tmp = random.nextInt(10);
            System.out.printf(tmp + " ");
            treeSet.add(tmp);
        }
        System.out.println(treeSet);
    }
}
