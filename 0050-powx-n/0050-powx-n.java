class Solution {
    public double myPow(double x, int n) {
        long nn=n;
        if(nn<0){
            x=1/x;
            nn=-nn;
        }
        return findPower(x,nn);
    }

    public double findPower(double x, long nn){
        if(nn==0){
            return 1.0;
        }

        double half=findPower(x,nn/2);

        if(nn%2==0){
            return half*half;
        }
        else{
            return half*half*x;
        }
    }
}