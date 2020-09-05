package leetcode.daily;

public class P657_JudgeCircle {
    public boolean judgeCircle(String moves) {
        if(moves.length() == 0) return true;
        if(moves.length() % 2 != 0) return false;
        int x = 0;
        int y = 0;
        for(char c : moves.toCharArray()){
            if(c == 'R') x += 1;
            if(c == 'L') x -= 1;
            if(c == 'U') y += 1;
            if(c == 'D') y -= 1;
        }
        if(x != 0 || y != 0) return false;
        return true;
    }
}
