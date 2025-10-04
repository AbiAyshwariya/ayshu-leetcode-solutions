class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int num: nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        int ans=-1;
        for(Map.Entry<Integer,Integer> mp:mpp.entrySet()){
            if(mp.getValue()==1){
                ans=mp.getKey();
            }
        }
        return ans;
    }
}