package exam.zte.test1;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;
        //
        int prev = 0;
        int cur = in.nextInt();
        for(int i = 0; i < 2*n - 1; i++){
            if (prev > cur){
                count++;
            }
            prev = cur;
            cur = in.nextInt();
        }

        System.out.println(count);

    }
}
