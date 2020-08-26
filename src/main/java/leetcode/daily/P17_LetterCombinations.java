package leetcode.daily;

import java.util.*;

public class P17_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations;

        Map<Character, String> phoneMap = new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());;
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination){
        if (index == digits.length()){
            combinations.add(combination.toString());
        } else {
            // 每次取电话号码的一位数字
            char digit = digits.charAt(index);
            // 取出这个数字对应的字符串
            String letters = phoneMap.get(digit);
            // 对应字符串的长度
            int letterCount = letters.length(); // 3 或者 4
            for (int i = 0; i < letterCount; i++) {
                // 遍历，并将其中的一个字母插入到已有的字母排列后面
                combination.append(letters.charAt(i));
                // 继续处理电话号码的后一位数字
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        P17_LetterCombinations p17_letterCombinations = new P17_LetterCombinations();
        List<String> strings = p17_letterCombinations.letterCombinations("23");
        for (String s:strings) {
            System.out.print(s + " ");

        }

    }
}
