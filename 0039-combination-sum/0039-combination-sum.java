class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int  n=candidates.length;
        List<Integer> list=new ArrayList<>();
        findCominations(candidates,0,target,list,ans,n);
        return ans;
    }

    public static void findCominations(int[] arr,int ind,int target, List<Integer> list,List<List<Integer>> ans,int n){
        if(ind==n){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[ind]<=target){
            list.add(arr[ind]);
            findCominations(arr,ind,target-arr[ind],list,ans,n);
            list.remove(list.size()-1);
        }
        findCominations(arr,ind+1,target,list,ans,n);
    }
}