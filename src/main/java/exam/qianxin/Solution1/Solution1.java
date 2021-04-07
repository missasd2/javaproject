package exam.qianxin.Solution1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    static List<List<String>> res = new ArrayList<>();
    static List<String> tmp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        boolean[] visited = new boolean[s1.length];
        Solution1 solution1 = new Solution1();

//        List<List<String>> res = new ArrayList<>();
//        List<String> tmp = new ArrayList<>();
        solution1.dfs(s1, 0, visited);

        List<List<String>> result = new ArrayList<>();

        for (List<String> e : res) {
            if (e.indexOf("A") < e.indexOf("B")) {
                result.add(e);
            }
        }

        StringBuilder pr = new StringBuilder();
        for (List<String> f : result) {
            StringBuilder builder = new StringBuilder();
            for (String s2: f) {
                builder.append(s2);
                builder.append("-");
            }
            builder.deleteCharAt(builder.toString().length() - 1);
            pr.append(builder.toString() + " ");
        }
        pr.append(result.size());

        System.out.println(pr.toString());

    }

    private static void dfs(String[] s1, int a, boolean[] visited) {

//        if (visited[0] && visited[1] && (tmp.indexOf("A") > tmp.indexOf("B"))) {
//            tmp.clear();
//            return;
//        }
        if (a == s1.length) {
            res.add(new ArrayList<>(tmp));
            //tmp.clear();
            return ;
        }
        for (int i = 0; i < s1.length; i++) {
            if (!visited[i]) {
                tmp.add(s1[i]);
                visited[i] = true;
                dfs(s1, a+1, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }

    }
}
