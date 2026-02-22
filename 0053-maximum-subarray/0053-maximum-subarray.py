class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n=len(nums)
        sum=0
        maxi=nums[0]
        for i in range(n):
            sum+=nums[i]
            maxi=max(maxi,sum)
            if sum<0:
                sum=0
        return maxi
        