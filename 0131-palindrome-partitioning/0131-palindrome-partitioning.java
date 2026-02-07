class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ls=new ArrayList<>();
        generate(s,ls,new ArrayList<>(),0);
        return ls;
    }

    public void generate(String str, List<List<String>> ls, List<String> arr,int ind){
        if(ind==str.length()){
            ls.add(new ArrayList<>(arr));
            return;
        }

        for(int i=ind;i<str.length();i++){
            if(checkPalindrome(str,ind,i)){
                arr.add(str.substring(ind,i+1));
                generate(str,ls,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
    }

    public boolean checkPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}