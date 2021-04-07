package exam.shence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Middle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        System.out.println(s);
        String[] splits = s.split(",");
        for (String c : splits) {
            list.add(Integer.valueOf(c));
        }
        Collections.sort(list);
        int len = list.size();
        if (len == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get((len-1)/2));
        }
    }
}
