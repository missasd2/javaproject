package leetcode.tag.str;

public class P8_MyAtoi {

    public int myAtoi(String str) {
        P8_Automaton automaton = new P8_Automaton();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public static void main(String[] args) {
        String str = "4193 with words";
        System.out.println(new P8_MyAtoi().myAtoi(str));
    }


}
