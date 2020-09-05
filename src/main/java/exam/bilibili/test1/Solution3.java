package exam.bilibili.test1;

public class Solution3 {
    public int GetFragment (String str) {
        // write code here
        int m = str.length();
        if (m == 0) return 0;
        char c = str.charAt(0);
        int count = 1;
        for(int i = 0; i < m - 1; i++){
            if ( str.charAt(i) != str.charAt(i+1)){
                count++;
            }
        }
        return m / count;
    }

}
