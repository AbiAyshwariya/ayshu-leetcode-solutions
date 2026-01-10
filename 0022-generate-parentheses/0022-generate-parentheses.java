class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        generate(n,0,0,0,"",list);
        return list;
    }

    public void generate(int n,int current,int open,int closed,String str,List<String> list){
        if(current==2*n){
            list.add(str);
            return;
        }
        if(open<n){
            generate(n,current+1,open+1,closed,str+"(",list);
        }
        if(closed<open){
            generate(n,current+1,open,closed+1,str+")",list);
        }
    }
}