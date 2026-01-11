class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }    

    public static void findCombinations(int[] arr, int ind, int target,List<Integer> list,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            list.add(arr[i]);
            findCombinations(arr,i+1,target-arr[i],list,ans);
            list.remove(list.size()-1);
        }


    }
}