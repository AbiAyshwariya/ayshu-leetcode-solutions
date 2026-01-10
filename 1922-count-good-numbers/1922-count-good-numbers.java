class Solution {
    private static int MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long evencount=(n+1)/2;
        long oddcount=n/2;
        long even_power=findPower(5,evencount);
        long odd_power=findPower(4,oddcount);
        
        return (int)((even_power*odd_power)%MOD);
    }
    
    public long findPower(int x, long n){
        if(n==0){
            return 1;
        }

        long half=findPower(x,n/2);
        if(n%2==0){
            return (half*half)%MOD;
        }
        else{
            return (half*half*x)%MOD;
        }
    }

}