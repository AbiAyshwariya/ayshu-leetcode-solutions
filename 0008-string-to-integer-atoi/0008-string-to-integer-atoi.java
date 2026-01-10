class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int index=0;
        if(s.length()==0){
            return 0;
        }
        int sign=1;
        if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }
        else if(s.charAt(index)=='+'){
            index++;
        }

        long result=helper(s,index,0L);
        result=result*sign;
        if(result>Integer.MAX_VALUE){return Integer.MAX_VALUE; };
        if(result<Integer.MIN_VALUE){return Integer.MIN_VALUE; };
        return (int)result;

    }

    public static long helper(String s, int index, long result){
        if(index>=s.length() || !Character.isDigit(s.charAt(index))){
            return result;
        }
        int digit=s.charAt(index)-'0';
        result=result*10+digit;

        if (result > (long) Integer.MAX_VALUE + 1) {
            return result;
        }
        return helper(s,index+1,result);
        
    }
}