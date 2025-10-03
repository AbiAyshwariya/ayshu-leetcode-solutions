class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int j;
        for(j=0;j<n;j++){
            if(nums[j]==0){
                break;
            }
        }

        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }
}