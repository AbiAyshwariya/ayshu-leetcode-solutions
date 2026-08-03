class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        Integer[] memo=new Integer[n];
        int result=solve(stoneValue,0,memo);
        if(result>0){
            return "Alice";
        }
        else if(result<0){
            return "Bob";
        }
        else{
            return "Tie";
        }

    }

    private int solve(int[] nums,int i,Integer[] memo){
        int n=nums.length;
        if(i>=n){
          return 0;
        }
        if(memo[i]!=null){
            return memo[i];
        }
        int takeone=Integer.MIN_VALUE;
        int taketwo=Integer.MIN_VALUE;
        int takethree=Integer.MIN_VALUE;
        takeone=nums[i]-solve(nums,i+1,memo);
        if(i+1<n){
            taketwo=nums[i]+nums[i+1]-solve(nums,i+2,memo);
        }
        if(i+2<n){
            takethree=nums[i]+nums[i+1]+nums[i+2]-solve(nums,i+3,memo);
        }
        return memo[i]=Math.max(Math.max(takeone,taketwo),takethree);
    }
}