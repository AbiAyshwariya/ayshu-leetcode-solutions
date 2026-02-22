import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n=nums.length;
       HashMap<Integer,Integer> mpp=new HashMap<>();
       for(int i=0;i<n;i++){
        int complement=target-nums[i];
        if(mpp.containsKey(complement)){
            return new int[]{i,mpp.get(complement)};
        }
        mpp.put(nums[i],i);
       }
       return new int[]{-1,-1};
    }
}