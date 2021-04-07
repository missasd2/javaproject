package exam.shence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        char[] argu = s.toCharArray();
        boolean[] visited = new boolean[n];
        String tmp = new String();
        List<String> res = new ArrayList<>();
//        List<String> tmp = new ArrayList<>();
        dfs(argu, visited, 0, n, tmp, res);
        System.out.println(res);


    }

    private static void dfs(char[] argu, boolean[] visited, int level, int n, String tmp, List<String> res) {
        if (level == n) {
            res.add(tmp);
            return;
        }

        for (int i = 0; i < argu.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp += argu[i];
                dfs(argu, visited, level+1, n, tmp, res);
                visited[i] = false;
                tmp = tmp.substring(0, tmp.length()-1);
            }
        }
    }
}
