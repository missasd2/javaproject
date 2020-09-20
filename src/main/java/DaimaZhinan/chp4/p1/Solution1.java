package DaimaZhinan.chp4.p1;

import javafx.scene.control.cell.CheckBoxListCell;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt(); // 公司的人数
        int m = sc.nextInt(); //今天打卡的数量
        // flag数组的第一位不使用，false表示不是员工，true表示是员工
        boolean[] flag = new boolean[n+1];
        int[] num = new int[m]; // 打卡编号数组
        int[] tag = new int[m]; // 打卡的数字1，0

        for (int i = 0; i < m; i++){
            num[i] = sc.nextInt();
            tag[i] = sc.nextInt();
        }

        // 从后往前，第二个0及以后的0都排除
        int count = 0;
        int first = 0;
        for (int i = m-1; i>=0; i--){
            if (tag[i] == 0){
                count++;
            }
            if (tag[i] == 0 && count == 1){
                first = i; // 记录最后下班的人的索引
            }
            if (count >= 2){
                flag[num[i]] = true;
            }
        }




        // 从前往后，第二个1以及以后的1都排除
        int co = 0;
        int second = 0;
        for (int i = 0; i<m; i++){
            if (tag[i] == 1){
                co++;
            }
            if (tag[i] == 1 && co==1){
                second = i; // 记录首次上班的索引
            }
            if (co >= 2){
                flag[num[i]] = true;
            }
        }

        // 剩余两个进行判断

        if (num[first] != num[second]){
            flag[num[second]] = true;
            flag[num[first]] = true;
        }



    helper(flag);


    }

    private static void helper(boolean[] flag){
        for (boolean b : flag){
            System.out.print(b + " ");
        }
    }
}
