class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<=n-k;i++){
             int maxi=Integer.MIN_VALUE;
           for(int j=i;j<i+k;j++){
              maxi=Math.max(maxi,nums[j]);
           }
           list.add(maxi);
        }
        int num=list.size();
        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}