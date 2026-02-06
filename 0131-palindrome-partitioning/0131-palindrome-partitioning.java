class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        List<List<String>> ls=new ArrayList<>();
        partition(s,n,ls,new ArrayList<>(),0);
        return ls;
    }

    public void partition(String s, int n, List<List<String>> ls, List<String> arr,int ind){
        if(ind==n){
            ls.add(new ArrayList<>(arr));
            return;
        }
        for(int i=ind;i<n;i++){
            if(checkPalindrome(s,ind,i)){
                arr.add(s.substring(ind,i+1));
                partition(s,n,ls,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
    }

    public boolean checkPalindrome(String s, int start, int end){
         while(start < end){
        if(s.charAt(start) != s.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
    }
}