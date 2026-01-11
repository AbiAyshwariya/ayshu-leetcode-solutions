class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        generate(candidates,0,target,list,ls);
        return ls;
    }

    public void generate(int[] arr,int ind,int target, List<Integer> list,List<List<Integer>> ls){
         if(target==0){
                ls.add(new ArrayList<>(list));
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
            generate(arr,i+1,target-arr[i],list,ls);
            list.remove(list.size()-1);
            
        }
    }
}