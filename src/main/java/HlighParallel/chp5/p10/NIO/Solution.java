package HlighParallel.chp5.p10.NIO;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int len = Integer.MAX_VALUE;
        if( strs.length == 0) return result;
        for(int i = 0; i< strs.length-1; i++){

            len = Math.min(len, strs[i].length());
            if( len == 0) return result;
        }
        //if( len == 0) return result;
        for(int i=0; i < len; i++){
            if( !check(strs, i)){
                break;
            }else{
                result += strs[0].charAt(i);
            }
        }
        return result;

    }

    private boolean check(String[] strs,  int i){
        if(strs[0].length() == 0) return false;
        char c = strs[0].charAt(i);
        for( int j=0; j < strs.length; j++){
            if(strs[j].charAt(i) != c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
