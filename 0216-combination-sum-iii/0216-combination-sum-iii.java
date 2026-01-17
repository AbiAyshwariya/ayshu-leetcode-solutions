class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        generate(1,n,k,list,ls);
        return ls;
    }
    public void generate(int start, int target,int k,List<Integer> list, List<List<Integer>> ls){
        if(list.size()==k){
            if(target==0 ){
                ls.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>target) break;
            list.add(i);
            generate(i+1,target-i,k,list,ls);
            list.remove(list.size()-1);
        }
    }
}