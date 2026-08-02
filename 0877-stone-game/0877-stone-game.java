class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer[][] memo=new Integer[n][n];
        return solve(piles,0,n-1,memo)>0;
    }

    public int solve(int[] piles,int i,int j,Integer[][] memo){
        if(i==j){
            return piles[i];
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int left=piles[i]-solve(piles,i+1,j,memo);
        int right=piles[j]-solve(piles,i,j-1,memo);
        return memo[i][j]=Math.max(left,right);
    }
}