package exam.guangdong;

public class Solution1 {
    public boolean validate(String pwd) {
        int len = pwd.length();
        // 1. 长度限制
        if (len < 8 || 20 < len) return false;
        //
        int u = 0;
        int l = 0;
        int d = 0;
        int s = 0;
        for(Character c : pwd.toCharArray()) {
            if (c == ' ') return false;
            if (Character.isUpperCase(c)){
                u = 1;
                continue;
            }
            if (Character.isLowerCase(c)){
                l = 1;
                continue;
            }
            if (Character.isDigit(c)){
                d = 1;
                continue;
            }
            if (Character.isJavaIdentifierPart(c)){
                s = 1;
                continue;
            }
        }
        if (u*l*d*s == 0) return false;
        return true;
    }
}
