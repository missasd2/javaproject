package leetcode.tag.str;

import java.util.ArrayList;
import java.util.List;

public class P6_ZConvert_2 {
    public String convert(String s, int rowNums) {
        if (rowNums == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        boolean goingDown = false;
        int curRow = 0;
        // 初始化行
        for (int i = 0; i < Math.min(s.length(), rowNums); i++) {
            rows.add(new StringBuilder());
        }

        // 填充字符
        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == rowNums - 1) goingDown = !goingDown; // 到达边界转向
            curRow += goingDown ? 1 : -1;
        }

        // 取出列表中的每行，拼接成一个字符串
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row.toString());
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        P6_ZConvert_2 solution = new P6_ZConvert_2();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(solution.convert(s, numRows));
    }
}
