package exam.sogou.test1;

public class Solution2 {
    public int numberofprize (int a, int b, int c) {
        // write code here
        int min = Math.min(a, Math.min(b,c));
        int sum = a+b+c;
        int avg = sum/3;
        while(avg>min){
            int pos = 0;
            int neg = 0;
            int diffA = a - avg;
            int diffB = b - avg;
            int diffC = c - avg;
            if(diffA > 0){
                pos += diffA;
            }else{
                neg += diffA;
            }
            if(diffB > 0){
                pos += diffB;
            }else{
                neg += diffB;
            }
            if(diffC > 0){
                pos += diffC;
            }else{
                neg += diffC;
            }
            if(pos>=2*Math.abs(neg)){
                return avg;
            }
            avg--;
        }
        return min;
    }
}
