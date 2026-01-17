class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> mpp=new HashMap<>(){{
            put(1,"");
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }};
        List<String> ans=new ArrayList<>();
        helper(digits,0,ans,"",mpp);
        return ans;
    }

    public void helper(String digits, int ind,List<String> ans, String current,Map<Integer,String> mpp){
        if(ind==digits.length()){
            ans.add(current);
            return;
        }
         String s = mpp.get(digits.charAt(ind) - '0');

        for (int i = 0; i < s.length(); i++) {
            helper(digits,  ind + 1,ans, current + s.charAt(i),mpp);
        }
    }
}